package nz.co.zufang.service;

import static io.restassured.RestAssured.given;

import org.junit.Test;

public class UserUpdateTest extends AbstractTest{

	@Test
    public void testUserUpdate(){
		given()
        .contentType("application/json")
        .body("{\"address\": \"string1\",\"email\": \"string1\",\"imAccount\": \"string1\",\"password\": \"string1\",\"phone\": \"string1\",\"uid\": \"uid\",\"username\": \"string1\"}")
        .when().post("http://localhost:8080/api/rent/register").then()
        .statusCode(200);
	}
	
}