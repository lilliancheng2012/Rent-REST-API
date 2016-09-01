package nz.co.zufang.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

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
	
	@Test
    public void testFindUserByUsername() {
		String username ="eeeeee";
		User user = userService.findUserByUsername(username);
		assertNotNull(user);
		assertEquals("eeeeee",user.getUsername());
    }
	
	
	@Test
    public void testAuthentication() {
		String username ="eeeeee";
		String password ="eeeeee";
		GenericResponse response = userService.authentication(username, password);
		assertNotNull(response);
		assertEquals("1000",response.getCode());
		try{
			String username1 ="123";
			String password1 ="123";
			userService.authentication(username1, password1);
		}catch(NotFoundException e){
			assertEquals("The resource you requested does not exist",e.getMessage());
		}
    }
	
	@Test
    public void testRegister() {
		String username ="55";
		String password ="555";
		String email = "555@qq.com";
		String imAccount = "555";
		String phone = "555";
		String address = "555 Rd";
		GenericResponse response = userService.register(username, password, email, imAccount, phone, address);
		assertEquals("1001",response.getCode());
		assertEquals("Register successfully",response.getMessage());
		assertNotNull(response.getToken());
		try{			
			userService.register(username, password, email, imAccount, phone, address);
		}catch(UserExistException e){
			assertEquals("The user is already registered.",e.getMessage());
		}
		try{
			userService.register("aa", password, email, imAccount, phone, address);
		}catch(UserExistException e){
			assertEquals("The user is already registered.",e.getMessage());
		}
    }
	
	@Test
    public void testUpdateUser() {
		User user = userService.findUser("4028d08155e90e7c0155e930f5070000");
		UserUpdateRequest updateUserRequest = new UserUpdateRequest();
		updateUserRequest.setUid(user.getUid());
		updateUserRequest.setEmail("000@qq.com");
		updateUserRequest.setUsername("lin");
		updateUserRequest.setPassword("qazwsx");
		updateUserRequest.setImAccount("0000");
		updateUserRequest.setPhone("00000");
		updateUserRequest.setAddress("242 Penrose");
		/*updateUserRequest.setEmail(user.getEmail());
		updateUserRequest.setUsername(user.getUsername());
		updateUserRequest.setPassword(user.getPassword());
		updateUserRequest.setImAccount(user.getImAccount());
		updateUserRequest.setPhone(user.getPhone());
		updateUserRequest.setAddress(user.getAddress());*/
		User user1 = userService.updateUser(updateUserRequest);
		assertEquals("000@qq.com",user1.getEmail());
		assertEquals("lin",user1.getUsername());
		assertEquals("qazwsx",user1.getPassword());
		assertEquals("0000",user1.getImAccount());
		assertEquals("00000",user1.getPhone());
		assertEquals("242 Penrose",user1.getAddress());
    }
	
	@Test
    public void testDeleteUser() {
		String username = "55";
		User user = userService.findUserByUsername(username);
		Boolean isDeleted = userService.deleteUser(user.getUid());
		assertTrue(isDeleted);
    }
	
	@Test
    public void testGetAllUser() {
		List<User> aa = userService.getAllUser();
		assertEquals(4,aa.size());
    }
	
	@Test
    public void testFindUser() {
		String id = "4028d08155e90e7c0155e930f5070000";
		User user = userService.findUser(id);
		assertEquals("lin",user.getUsername());
    }
}
