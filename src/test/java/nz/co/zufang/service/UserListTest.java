package nz.co.zufang.service;

import static io.restassured.RestAssured.given;

import org.junit.Test;

public class UserListTest {

	@Test
    public void testUserList() {
		given()
        .when().get("http://localhost:8080/rent/listUsers").then()
        .statusCode(200);
    }
	
}