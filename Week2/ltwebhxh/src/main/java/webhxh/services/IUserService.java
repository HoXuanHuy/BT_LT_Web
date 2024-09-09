package webhxh.services;

import webhxh.model.UserModel;

public interface IUserService {
	
	String login(String username, String password);
	UserModel get(String username);

}
