package nz.co.zufang.service;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import com.google.gson.Gson;

import nz.co.zufang.model.BasicUserReg;

public class UserRegisterTest {

	@Test
    public void testUserRegister() {
		
		BasicUserReg user = new BasicUserReg();
		user.setAddress("weymonth Rd");
		user.setEmail("emailtest1@gmail.com");
		user.setImAccount("wechat");
		user.setPassword("1111");
		user.setPhone("222");
		user.setUsername("tester1");
		
		Gson gson = new Gson();
		String body = gson.toJson(user);
		
		given()
        .contentType("application/json")
        .body(body)
        .when().post("http://localhost:8080/rent/register").then()
        .body("message",equalTo("Register successfully"))
        .statusCode(200);
    }
	
}
