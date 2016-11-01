package nz.co.zufang.service;

import static io.restassured.RestAssured.expect;

import org.junit.BeforeClass;

import nz.co.zufang.controller.GenericResponse;

public class AbstractTest {

	public static GenericResponse genericResponse;
	
	@BeforeClass
	public static void setup() {
		//Set SSL configuration
		/*RestAssured.config = RestAssured.config.sslConfig(SSLConfig.sslConfig().allowAllHostnames());*/
		
		//Each Test case need login first to get the registeredUID
		genericResponse =  expect()
		.statusCode(200)
		.given()
        .contentType("application/json")
        .body("{\"address\": \"weymonth Rd\",\"email\": \"emailtest2@gmail.com\",\"imAccount\": \"wechat\",\"password\": \"1111\",\"phone\": \"22222\",\"username\": \"tester2\"}")
        .post("http://localhost:8080/api/rent/register")
        .andReturn()
        .body()
        .as(GenericResponse.class);
	}
}
