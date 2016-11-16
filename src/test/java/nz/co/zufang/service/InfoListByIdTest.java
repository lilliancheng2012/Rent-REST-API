package nz.co.zufang.service;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class InfoListByIdTest extends AbstractInfoTest{

	@Test
	public void testInfoListByID() {
		
		given()
        .when().get("http://localhost:8080/info/" + info.getId()).then()
        .body("email",equalTo("lillian.cheng2012@gmail.com"))
        .statusCode(200);
	}
	
}
