package dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;

import entity.User;

/**
 * @author Vinicius Pedro da Silveira
 */

public class UserDAO extends PersistenceBasic<User> {

	@Override
	public void inicialize() {
		setEntityClass(User.class);
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() throws Exception {

		List<User> users;
		StringBuilder sql = new StringBuilder();
		sql.append("select u from users u");

		SQLQuery query = null;
		query = getSQLQuery(sql.toString());
		query.setResultTransformer(Transformers.aliasToBean(User.class));

		users = query.list();

		return users;
	}

}
