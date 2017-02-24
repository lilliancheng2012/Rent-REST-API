package nz.co.zufang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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
	public User createUser(@RequestBody UserCreate userCreate) {
		return userService.createUser(userCreate);
	}


	@RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
	@PreAuthorize("@securityService.hasProtectedAccess()")
	public User getUser(@RequestHeader(value="X-Auth-Token") String header, @PathVariable String userId) {
		return userService.findUser(userId);
	}


}
