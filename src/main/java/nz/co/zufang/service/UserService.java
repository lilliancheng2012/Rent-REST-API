package nz.co.zufang.service;

import java.util.List;

import nz.co.zufang.controller.GenericResponse;
import nz.co.zufang.model.User;
import nz.co.zufang.model.UserCreate;

public interface UserService {
	
	public GenericResponse authentication(String username, String password);
	
	public User createUser(UserCreate basicUserReg);

	Boolean deleteUser(String id);
	
	User findUser(String id);
	
	User findUserByUsername(String username);
	
	List<User> getAllUser();
}