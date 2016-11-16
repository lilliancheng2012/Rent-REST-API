package nz.co.zufang.service;

import static io.restassured.RestAssured.given;

import org.junit.Test;

import com.google.gson.Gson;

import nz.co.zufang.controller.UserUpdateRequest;

public class UserUpdateTest extends AbstractTest{

	@Test
    public void testUserUpdate(){
		
		UserUpdateRequest user = new UserUpdateRequest();
		user.setUid(genericResponse.getUid());
		user.setEmail("aa@qq.com");
		user.setImAccount("wechat");
		user.setAddress("string1");
		user.setUsername("Test Name");
		user.setPassword("string1");
		user.setPhone("0222762000");
		
		Gson gson = new Gson();
		String body = gson.toJson(user);
		
		given()
        .contentType("application/json")
        .body(body)
        .when().post("http://localhost:8080/rent/updateUser").then()
        .statusCode(200);
	}
	
}