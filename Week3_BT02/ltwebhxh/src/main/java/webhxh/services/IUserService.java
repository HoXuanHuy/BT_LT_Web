package webhxh.services;

import webhxh.model.UserModel;

public interface IUserService {
	
	UserModel login(String username, String password);
	UserModel findByUsername(String username);

}
