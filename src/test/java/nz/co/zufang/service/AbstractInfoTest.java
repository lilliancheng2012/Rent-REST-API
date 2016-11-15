package nz.co.zufang.service;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.junit.BeforeClass;
import com.google.gson.Gson;
import nz.co.zufang.controller.InfoCreateRequest;

public class AbstractInfoTest {

	@BeforeClass
	public static void setup() {
		//Each Test case need to create Info first to get the registeredID
		InfoCreateRequest info = new InfoCreateRequest();
		info.setTitle("House rent");
		info.setKeywords("Penrose");
		info.setDescription("Good house in Penrose");
		info.setLinkMan("Mr. Li");
		info.setFee(120.00);
		info.setEmail("lillian.cheng2012@gmail.com");
		info.setQq("123456");
		info.setPhone("0225647776");
		info.setAddress("242 Penrose Road");
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
