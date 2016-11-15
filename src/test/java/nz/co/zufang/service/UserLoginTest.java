package nz.co.zufang.service;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import com.google.gson.Gson;

import nz.co.zufang.model.BasicUserLogin;

public class UserLoginTest extends AbstractTest{

	@Test
    public void testUserLogin() {
		BasicUserLogin user = new BasicUserLogin();
		user.setUserName("Tester2");
		user.setPassword("pass2016");
		
		Gson gson = new Gson();
		String body = gson.toJson(user);
		
		given()
        .contentType("application/json")
        .body(body)
        .when().post("http://localhost:8080/api/rent/login").then()
        .body("message",equalTo("Login successfully"))
        .statusCode(200);
    }
	
}
