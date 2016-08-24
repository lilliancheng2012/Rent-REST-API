package nz.co.zufang.service;

import java.util.List;

import nz.co.zufang.controller.GenericResponse;
import nz.co.zufang.controller.UserUpdateRequest;
import nz.co.zufang.model.User;

public interface UserService {
	
	public GenericResponse authentication(String username, String password);
	
	public GenericResponse register(String username, String password, String email, String imAccount, String phone, String address);

	public User updateUser(UserUpdateRequest updateUserRequest);

	Boolean deleteUser(String id);
	
	User findUser(String id);
	
	User findUserByUsername(String username);
	
	List<User> getAllUser();
}