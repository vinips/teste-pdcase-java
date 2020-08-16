package business;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateful;
import javax.inject.Inject;

import dao.UserDAO;
import dto.UserDTO;
import util.Filter;

/**
 * @author  Vinicius Pedro da Silveira
 */

@Stateful
public class UserBusiness {
	
	@Inject
	private UserDAO repository;
	
	public List<UserDTO> getAllUsers(Map<String, Object> map, Filter filter) throws Exception {
		String username = (String) map.get("username");
		String name = (String) map.get("name");
		String email = (String) map.get("email");
		return repository.getAllUsers(username, name, email, filter);
	}

	public Integer searchCount(Map<String, Object> map) throws Exception {
		String username = (String) map.get("username");
		String name = (String) map.get("name");
		String email = (String) map.get("email");
		return repository.getCountUsers(username, name, email);
	}

}
