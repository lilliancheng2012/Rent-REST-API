package nz.co.zufang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nz.co.zufang.model.User;
import nz.co.zufang.model.UserCreate;
import nz.co.zufang.service.UserService;

/**
 * Created by Lillian on 2/25/2016.
 */
@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public ResponseEntity<GenericResponse> createUser(@RequestBody UserCreate userCreate) {
		GenericResponse response = userService.register(userCreate);
		return new ResponseEntity<GenericResponse>(response, HttpStatus.OK);
	}


	@RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
	@PreAuthorize("@securityService.hasProtectedAccess()")
	public User getUser(@PathVariable String userId) {
		return userService.findUser(userId);
	}


}
