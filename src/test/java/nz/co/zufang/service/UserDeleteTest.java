package nz.co.zufang.service;

import static io.restassured.RestAssured.given;

import org.junit.Test;

public class UserDeleteTest extends AbstractTest{
	
	@Test
    public void testUserUpdate() {
		given()
        .contentType("application/json")
        .when().delete("http://localhost:8080/rent/deleteUser/" + genericResponse.getUid()).then()
        .statusCode(200);
	}

}
