package nz.co.zufang.service;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.junit.Test;
import com.google.gson.Gson;
import nz.co.zufang.controller.InfoCreateRequest;

public class InfoCreateTest {

	@Test
    public void testInfoCreate() {
		InfoCreateRequest info = new InfoCreateRequest();
		info.setTitle("House rent");
		info.setKeywords("Penrose");
		info.setDescription("good house in Penrose");
		info.setLinkMan("Mr. a");
		info.setFee(120.00);
		info.setEmail("linlin.cheng2012@gmail.com");
		info.setQq("123");
		info.setPhone("0222762000");
		info.setAddress("242 Penrose Rd");
		info.setMapPoint("Auckland");
		info.setPostArea("1060");
		
		Gson gson = new Gson();
		String body = gson.toJson(info);
		
		given()
        .contentType("application/json")
        .body(body)
        .when().post("http://localhost:8080/api/createInfo/").then()
        .body("email",equalTo("linlin.cheng2012@gmail.com"))
        .statusCode(200);
    }
}