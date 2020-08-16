package dao;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;

import entity.User;
import util.Filter;

/**
 * @author Vinicius Pedro da Silveira
 */

public class UserDAO extends PersistenceBasic<User> {

	@Override
	public void inicialize() {
		setEntityClass(User.class);
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers(String username, String name, String email, Filter filter) throws Exception {

		SQLQuery query = getSQl(username, name, email, filter);
		query.setResultTransformer(Transformers.aliasToBean(User.class));
		List<User> users = query.list();

		return users == null ? null : users;
	}

	public Integer getCountUsers(String username, String name, String email) {
		SQLQuery query = getSQl(username, name, email, null);
		BigInteger result = (BigInteger) query.uniqueResult();
		return result.intValue();
	}

	public SQLQuery getSQl(String username, String name, String email, Filter filter) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT ");

			if (filter != null) {
				sql.append("u.* ");
			} else
				sql.append("count(u.id) ");

			sql.append("FROM users u ");
			sql.append("WHERE 1=1 ");

			if (!username.isBlank()) {
				sql.append("AND u.username LIKE :username ");
			}
			if (!name.isBlank()) {
				sql.append("AND u.name LIKE :name ");
			}
			if (!email.isBlank()) {
				sql.append("AND u.email LIKE :email ");
			}

			if (filter != null) {
				sql.append("ORDER BY ");

				if (filter.getPropertyOrder().equals("id")) {
					sql.append("u.id ");
				} else if (filter.getPropertyOrder().equals("username")) {
					sql.append("u.username ");
				} else if (filter.getPropertyOrder().equals("password")) {
					sql.append("u.password ");
				} else if (filter.getPropertyOrder().equals("is_enabled")) {
					sql.append("u.is_enabled ");
				} else if (filter.getPropertyOrder().equals("register_date")) {
					sql.append("u.register_date ");
				} else if (filter.getPropertyOrder().equals("name")) {
					sql.append("u.name ");
				} else if (filter.getPropertyOrder().equals("surname")) {
					sql.append("u.surname ");
				} else if (filter.getPropertyOrder().equals("email")) {
					sql.append("u.email ");
				} else {
					sql.append("u.phone ");
				}

				sql.append(filter.isAscendant() ? "ASC " : "DESC ");
				sql.append("LIMIT :limit OFFSET :first");
			}

			SQLQuery query = getSQLQuery(sql.toString());

			if (filter != null) {
				query.setInteger("limit", filter.getAmountRecords());
				query.setInteger("first", filter.getFirstRecord());
			}

			if (!username.isBlank()) {
				query.setString("username", "%" + username + "%");
			}
			if (!name.isBlank()) {
				query.setString("name", "%" + name + "%");
			}
			if (!email.isBlank()) {
				query.setString("email", "%" + email + "%");
			}

			return query;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
