package nz.co.zufang.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import nz.co.zufang.Bootstrap;
import nz.co.zufang.controller.GenericResponse;
import nz.co.zufang.controller.UserUpdateRequest;
import nz.co.zufang.exception.NotFoundException;
import nz.co.zufang.exception.UserExistException;
import nz.co.zufang.model.BasicUserReg;
import nz.co.zufang.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Bootstrap.class)
@WebAppConfiguration
public class UserServiceTest {
	
	@Autowired
	UserService userService;
	
	@Before
    public void testRegister() {
		BasicUserReg user = new BasicUserReg();
		user.setUsername("Lillian");
		user.setPassword("Password");
		user.setEmail("linlin.cheng2012@gmail.com");
		user.setImAccount("634500997");
		user.setPhone("0222762000");
		user.setAddress("242 Penrose Rd");
		
		//To test register new user successfully
		GenericResponse response = userService.register(user);
		assertEquals("1000",response.getCode());
		assertEquals("Register successfully",response.getMessage());
		assertNotNull(response.getToken());
		//To verify the exception message when registered by the same user name
		try{			
			userService.register(user);
		}catch(UserExistException e){
			assertEquals("The user is already registered.",e.getMessage());
		}
		//Verify the exception message when registered by the same email
		try{
			user.setUsername("Lillian2");
			userService.register(user);
		}catch(UserExistException e){
			assertEquals("The user is already registered.",e.getMessage());
		}
    }
	
	@Test
    public void testFindUserByUsername() {
		//To test find user by the user name
		String username ="Lillian";
		User user = userService.findUserByUsername(username);
		assertNotNull(user);
		assertEquals("Lillian",user.getUsername());
    }
	
	@Test
    public void testFindUser() {
		//To test find user by user id
		String username ="Lillian";
		User user1 = userService.findUserByUsername(username);
		User user = userService.findUser(user1.getUid());
		assertEquals("Lillian",user.getUsername());
    }
	
	@Test
    public void testAuthentication() {
		//To test login successfully with correct user name and password
		String username ="Lillian";
		String password ="Password";
		GenericResponse response = userService.authentication(username, password);
		assertNotNull(response);
		assertEquals("1000",response.getCode());
		//To test the exception message when login with user which is not exist 
		try{
			String username1 ="NotExistUser";
			String password1 ="Password";
			userService.authentication(username1, password1);
		}catch(NotFoundException e){
			assertEquals("The resource you requested does not exist",e.getMessage());
		}
    }
	
	@Test
    public void testUpdateUser() {
		//To test update user information and verification
		String username ="Lillian";
		User user = userService.findUserByUsername(username);
		UserUpdateRequest updateUserRequest = new UserUpdateRequest();
		updateUserRequest.setUid(user.getUid());
		updateUserRequest.setUsername(user.getUsername());
		updateUserRequest.setEmail("000@qq.com");
		updateUserRequest.setPassword("qazwsx");
		updateUserRequest.setImAccount("0000");
		updateUserRequest.setPhone("0222762111");
		updateUserRequest.setAddress("242 Penrose");
		User user1 = userService.updateUser(updateUserRequest);
		assertEquals("000@qq.com",user1.getEmail());
		assertEquals("qazwsx",user1.getPassword());
		assertEquals("0000",user1.getImAccount());
		assertEquals("0222762111",user1.getPhone());
		assertEquals("242 Penrose",user1.getAddress());
    }
	
	@Test
    public void testGetAllUser() {
		//To test get list for all users 
		List<User> all = userService.getAllUser();
		assertFalse(all.isEmpty());
    }
	
	@After
    public void testDeleteUser() {
		//To test delete the user success after find it
		String username = "Lillian";
		User user = userService.findUserByUsername(username);
		Boolean isDeleted = userService.deleteUser(user.getUid());
		assertTrue(isDeleted);
    }
}
