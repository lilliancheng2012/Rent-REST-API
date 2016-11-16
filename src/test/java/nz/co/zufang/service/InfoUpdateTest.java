package nz.co.zufang.service;

import static io.restassured.RestAssured.given;

import org.junit.Test;

import com.google.gson.Gson;

import nz.co.zufang.controller.InfoUpdateRequest;

public class InfoUpdateTest extends AbstractInfoTest{
	
	@Test
	public void testInfoUpdate() {		
		InfoUpdateRequest info1 = new InfoUpdateRequest();
		info1.setId(info.getId()); 
		info1.setTitle("House rent 1");
		info1.setKeywords("Penrose 1");
		info1.setDescription("Good house in Penrose MT Wellington");
		info1.setLinkMan("Mrs. Li");
		info1.setFee(100.00);
		info1.setEmail("123@gmail.com");
		info1.setQq("6543210");
		info1.setPhone("1234567890");
		info1.setAddress("242 Penrose Road MT Wellington, Auckland");
		info1.setMapPoint("Auckland");
		info1.setPostArea("1060");
		info1.setContent("string");
		
		Gson gson = new Gson();
		String body = gson.toJson(info);
		
		given()
		.contentType("application/json")
        .body(body)
        .when().post("http://localhost:8080/updateInfo/").then()
        .statusCode(200);
	}

}
