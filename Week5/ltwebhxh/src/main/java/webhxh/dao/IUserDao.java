package webhxh.dao;

import java.util.List;

import webhxh.model.UserModel;

public interface IUserDao {
	
	List<UserModel> findAll();
	
	UserModel findById(int id);
	
	void insert(UserModel user);
	
	boolean CheckEmailExist(String Email);
	
	boolean CheckUserExist(String User);
	
	UserModel findbyUser(String User); 
	
	UserModel findByUsername(String username);
	
	UserModel changepassword (String username, String password);
	
	UserModel updateprofile (String username, String fullname, String phone, String image);
	
}
