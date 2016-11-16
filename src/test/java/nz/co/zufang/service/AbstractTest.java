package nz.co.zufang.service;

import static io.restassured.RestAssured.expect;

import org.junit.BeforeClass;

import com.google.gson.Gson;

import nz.co.zufang.controller.GenericResponse;
import nz.co.zufang.model.BasicUserReg;

public class AbstractTest {

	public static GenericResponse genericResponse;
	
	@BeforeClass
	public static void setup() {
		//Set SSL configuration
		/*RestAssured.config = RestAssured.config.sslConfig(SSLConfig.sslConfig().allowAllHostnames());*/
		
		//Each Test case need login first to get the registeredUID
		BasicUserReg user = new BasicUserReg();
		user.setAddress("weymonth Rd");
		user.setEmail("emailtest2@gmail.com");
		user.setImAccount("wechat1");
		user.setPassword("pass2016");
		user.setPhone("0225647776");
		user.setUsername("Tester2");
		
		Gson gson = new Gson();
		String body = gson.toJson(user);
		
		genericResponse = expect()
		.statusCode(200)
		.given()
        .contentType("application/json")
        .body(body)
        .post("http://localhost:8080/rent/register")
        .andReturn()
        .body()
        .as(GenericResponse.class);
	}
}