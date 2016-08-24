//package nz.co.zufang.controller;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import nz.co.zufang.model.User;
//import nz.co.zufang.service.UserService;
//
//@ActiveProfiles("test")
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = UserController.class)
//public class UserControllerTest {
//
//	private MockMvc mockMvc;
//
//	@Autowired
//	UserService userService;
//
//	@Test
//	public void listUser() throws Exception {
//		List<User> uses = new ArrayList<User>();
//		uses.add(new User());
//		Mockito.when(userService.getAllUser()).thenReturn(uses);
//		userService.getAllUser();
////		mockMvc.perform(get("/rent/listUsers")).andExpect(status().isNotFound());
//
//		// verify(userServiceMock, times(1)).findById(1L);
//		// verifyNoMoreInteractions(userServiceMock);
//	}
//
//}
