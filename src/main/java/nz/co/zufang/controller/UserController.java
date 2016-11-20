package nz.co.zufang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nz.co.zufang.model.BasicUserLogin;
import nz.co.zufang.model.BasicUserReg;
import nz.co.zufang.model.User;
import nz.co.zufang.service.UserService;

/**
 * Created by Lillian on 2/25/2016.
 */
@RestController
@RequestMapping("/rent")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<GenericResponse> register(@RequestBody BasicUserReg userReg) {
		GenericResponse response = userService.register(userReg);
		return new ResponseEntity<GenericResponse>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<GenericResponse> login(@RequestBody BasicUserLogin userLogin) {
		GenericResponse response = userService.authentication(userLogin.getUserName(), userLogin.getPassword());
		return new ResponseEntity<GenericResponse>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public User updateUser(@RequestBody UserUpdateRequest updateUser) {
		User user = userService.updateUser(updateUser);
		return user;
	}
	
	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteUser(@PathVariable String id){
		Boolean isDeleted = userService.deleteUser(id);
    	return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/listUsers",method = RequestMethod.GET)
    public List<User> listUser(){
    	return userService.getAllUser();		
	}
	
	@RequestMapping(value = "/findUserByUsername/{username}",method = RequestMethod.GET)
	public User findUserByUsername(@PathVariable String username) {
    	User user = userService.findUserByUsername(username);
    	return user;
	}
	
	
}
