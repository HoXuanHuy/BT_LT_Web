package webhxh.services.impl;

import webhxh.dao.impl.UserDaoImpl;
import webhxh.model.UserModel;
import webhxh.services.IUserService;

public class UserService implements IUserService {

	@Override
	public String login(String username, String password) {
		// TODO Auto-generated method stub
		UserDaoImpl userDao = new UserDaoImpl();
		UserModel user = userDao.findbyUser(username);
		if (user == null) {
			return "No account information matches with username. Check again!";
		}
		else if (password.equals(user.getPassword())) {
			
			return "Welcome " + user.getFullname() ;
		}
		return "Password incorrect.Check again!";
	}

	@Override
	public UserModel get(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
