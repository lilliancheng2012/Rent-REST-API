package nz.co.zufang.service;

import static io.restassured.RestAssured.given;
import org.junit.Test;

public class InfoListAllTest {
	
	@Test
	public void testInfoListAll() {
		
		given()
        .when().get("http://localhost:8080/list").then()
        .statusCode(200);
	}
	
}
