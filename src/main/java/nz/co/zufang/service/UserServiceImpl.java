package nz.co.zufang.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nz.co.zufang.controller.GenericResponse;
import nz.co.zufang.controller.UserUpdateRequest;
import nz.co.zufang.exception.NotFoundException;
import nz.co.zufang.exception.UserExistException;
import nz.co.zufang.model.User;
import nz.co.zufang.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	


	@Autowired
	UserRepository userRepository;
	
	@Override
	public User findUserByUsername(String username) {
		User user = userRepository.findByUsername(username);
		return user;
	}

	@Override
	public GenericResponse authentication(String username, String password) {
		// TODO this would be replaced with Oauth2
		User user = userRepository.findByUsernameAndPassword(username, password);
		if (user == null)
			throw new NotFoundException();
		// TODO token would be created by Oauth2
		UUID uuid = UUID.randomUUID();
		GenericResponse response = new GenericResponse();
		response.setCode("1000");
		response.setMessage("Login successfully");
		response.setToken(uuid.toString());
		return response;
	}

	@Override
	public GenericResponse register(String username, String password, String email, String imAccount, String phone,
			String address) {

		User tmpUser = userRepository.findByUsername(username);
		if (tmpUser != null)
			throw new UserExistException();

		User tmpEmail = userRepository.findByEmail(email);
		if (tmpEmail != null)
			throw new UserExistException();

		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setImAccount(imAccount);
		user.setPhone(phone);
		user.setAddress(address);

		user = userRepository.save(user);
		// TODO token would be created by Oauth2
		UUID uuid = UUID.randomUUID();
		GenericResponse response = new GenericResponse();
		response.setCode("1001");
		response.setMessage("Register successfully");
		response.setToken(uuid.toString());
		return response;
	}

	@Override
	public User updateUser(UserUpdateRequest userUpdateRequest) {
		User user = userRepository.findOne(userUpdateRequest.getUid());
		user.setUsername(userUpdateRequest.getUsername());
		user.setPassword(userUpdateRequest.getPassword());
		user.setEmail(userUpdateRequest.getEmail());
		user.setImAccount(userUpdateRequest.getImAccount());
		user.setPhone(userUpdateRequest.getPhone());
		user.setAddress(userUpdateRequest.getAddress());
		user = userRepository.save(user);
		return user;
	}

	@Override
	public Boolean deleteUser(String id) {
		userRepository.delete(id);
		return true;
	}

	@Override
	public List<User> getAllUser() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User findUser(String id) {
		User user = userRepository.findOne(id);
		return user;
	}


}