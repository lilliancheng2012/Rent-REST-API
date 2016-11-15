package nz.co.zufang.service;

import static io.restassured.RestAssured.given;

import org.junit.Test;

public class InfoDeleteById  extends AbstractInfoTest{
	
	@Test
	public void testInfoDeleteByID() {
		given()
        .contentType("application/json")
        .when().delete("http://localhost:8080/api/deleteInfo/" + info.getId()).then()
        .statusCode(200);
	}

}
