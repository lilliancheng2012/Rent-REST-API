package nz.co.zufang.service;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class UserRegisterTest {

	@Test
    public void testUserRegister() {
		given()
        .contentType("application/json")
        .body("{\"address\": \"weymonth Rd\",\"email\": \"emailtest1@gmail.com\",\"imAccount\": \"wechat\",\"password\": \"1111\",\"phone\": \"22222\",\"username\": \"tester1\"}")
        .when().post("http://localhost:8080/api/rent/register").then()
        .body("message",equalTo("Register successfully"))
        .statusCode(200);
    }
	
}
