package nz.co.zufang.service;

import static io.restassured.RestAssured.expect;

import org.junit.BeforeClass;

import com.google.gson.Gson;

import nz.co.zufang.controller.InfoCreateRequest;
import nz.co.zufang.model.Info;

public class AbstractInfoTest {

	public static Info info;
	
	@BeforeClass
	public static void setup() {
		//Each Test case need to create Info first to get the registeredID
		InfoCreateRequest info1 = new InfoCreateRequest();
		info1.setTitle("House rent");
		info1.setKeywords("Penrose");
		info1.setDescription("Good house in Penrose");
		info1.setLinkMan("Mr. Li");
		info1.setFee(120.00);
		info1.setEmail("lillian.cheng2012@gmail.com");
		info1.setQq("123456");
		info1.setPhone("0225647776");
		info1.setAddress("242 Penrose Road");
		info1.setMapPoint("Auckland");
		info1.setPostArea("1060");
		
		Gson gson = new Gson();
		String body = gson.toJson(info1);
		
		info = expect()
		.statusCode(200)
		.given()
		.contentType("application/json")
		.body(body)
		.post("http://localhost:8080/createInfo/")
		.andReturn()
		.body()
		.as(Info.class);
	}
}
