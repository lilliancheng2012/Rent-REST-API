package nz.co.zufang.service;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class UserLoginTest extends AbstractTest{

	@Test
    public void testUserLogin() {
		given()
        .contentType("application/json")
        .body("{\"password\": \"1111\",\"userName\": \"tester2\"}")
        .when().post("http://localhost:8080/api/rent/login").then()
        .body("message",equalTo("Login successfully"))
        .statusCode(200);
    }
	
}
