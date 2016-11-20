package nz.co.zufang.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nz.co.zufang.controller.GenericResponse;
import nz.co.zufang.controller.UserUpdateRequest;
import nz.co.zufang.exception.NotFoundException;
import nz.co.zufang.exception.UserExistException;
import nz.co.zufang.model.BasicUserReg;
import nz.co.zufang.model.User;
import nz.co.zufang.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	


	@Autowired
	UserRepository userRepository;
	

	@Override
	public GenericResponse authentication(String username, String password) {
		// TODO this would be replaced with Oauth2
		User user = userRepository.findUserByUsernameAndPassword(username, password);
		if (user == null)
			throw new NotFoundException();
		// TODO token would be created by Oauth2
		UUID uuid = UUID.randomUUID();
		GenericResponse response = new GenericResponse();
		response.setCode("1000");
		response.setMessage("Login successfully");
		response.setToken(uuid.toString());
		response.setUid(user.getUid());
		return response;
	}

	@Override
	public GenericResponse register(BasicUserReg basicUserReg) {

		User tmpUser = userRepository.findUserByUsername(basicUserReg.getUsername());
		if (tmpUser != null)
			throw new UserExistException();

		User tmpEmail = userRepository.findUserByEmail(basicUserReg.getEmail());
		if (tmpEmail != null)
			throw new UserExistException();

		User user = new User();
		user.setUsername(basicUserReg.getUsername());
		user.setPassword(basicUserReg.getPassword());
		user.setEmail(basicUserReg.getEmail());
		user.setImAccount(basicUserReg.getImAccount());
		user.setPhone(basicUserReg.getPhone());
		user.setAddress(basicUserReg.getAddress());

		user = userRepository.save(user);
		// TODO token would be created by Oauth2
		UUID uuid = UUID.randomUUID();
		GenericResponse response = new GenericResponse();
		response.setCode("1000");
		response.setUid(user.getUid());
		response.setMessage("Register successfully");
		response.setToken(uuid.toString());
		
		return response;
	}

	@Override
	public User updateUser(UserUpdateRequest userUpdateRequest) {
		User user = userRepository.findOne(userUpdateRequest.getUid());
		user.setUid(userUpdateRequest.getUid());
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

	@Override
	public User findUserByUsername(String username) {
		User user = userRepository.findUserByUsername(username);
		return user;
	}
	
}
