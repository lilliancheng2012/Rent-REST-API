package nz.co.zufang.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
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
import nz.co.zufang.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Bootstrap.class)
@WebAppConfiguration
public class UserServiceTest {
	
	@Autowired
	UserService userService;
	
	@Before
    public void testRegister() {
		String username ="Lillian";
		String password ="Password";
		String email = "linlin.cheng2012@gmail.com";
		String imAccount = "634500997";
		String phone = "0222762000";
		String address = "242 Penrose Rd";
		//TODO
		GenericResponse response = userService.register(username, password, email, imAccount, phone, address);
		assertEquals("1001",response.getCode());
		assertEquals("Register successfully",response.getMessage());
		assertNotNull(response.getToken());
		//TODO
		try{			
			userService.register(username, password, email, imAccount, phone, address);
		}catch(UserExistException e){
			assertEquals("The user is already registered.",e.getMessage());
		}
		//TODO
		try{
			userService.register("A", password, email, imAccount, phone, address);
		}catch(UserExistException e){
			assertEquals("The user is already registered.",e.getMessage());
		}
    }
	
	@Test
    public void testFindUserByUsername() {
		//TODO
		String username ="Lillian";
		User user = userService.findUserByUsername(username);
		assertNotNull(user);
		assertEquals("Lillian",user.getUsername());
    }
	
	@Test
    public void testFindUser() {
		//TODO
		String username ="Lillian";
		User user1 = userService.findUserByUsername(username);
		User user = userService.findUser(user1.getUid());
		assertEquals("Lillian",user.getUsername());
    }
	
	@Test
    public void testAuthentication() {
		//TODO
		String username ="Lillian";
		String password ="Password";
		GenericResponse response = userService.authentication(username, password);
		assertNotNull(response);
		assertEquals("1000",response.getCode());
		//TODO
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
		//TODO
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
		//TODO
		List<User> all = userService.getAllUser();
		assertFalse(all.isEmpty());
    }
	
	@After
    public void testDeleteUser() {
		String username = "Lillian";
		User user = userService.findUserByUsername(username);
		Boolean isDeleted = userService.deleteUser(user.getUid());
		assertTrue(isDeleted);
    }
}
