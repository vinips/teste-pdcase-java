package business;

import java.util.List;

import javax.ejb.Stateful;
import javax.inject.Inject;

import dao.UserDAO;
import entity.User;

/**
 * @author  Vinicius Pedro da Silveira
 */

@Stateful
public class UserBusiness {
	
	@Inject
	private UserDAO repository;
	
	public String register (User user) {
		
		return null;
	}
	
	public List<User> getAllUsers() throws Exception {
		return repository.getAllUsers();
	}

}
