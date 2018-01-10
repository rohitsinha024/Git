package APITesting.com.org.api;

import javax.annotation.meta.When;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;
import com.jayway.restassured.response.ResponseBodyData;
import com.jayway.restassured.specification.RequestSpecification;

import static com.jayway.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NewRequest {

	//@Test
	public void test1(){
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/patna");
		ResponseBody body = response.getBody();
		System.out.println(body.asString());
		Assert.assertEquals("test will pass if status codes are same"+response.statusCode(), 200);
		
	}
	
	@Test
	public void test2(){
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RestAssured.basePath = "/utilities/weather/city";
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.get("/hyderabad");
		ResponseBodyData data = response.body();
		System.out.println(data.asString());
		System.out.println(response.then().contentType(ContentType.JSON).extract().path("City"));
		String jsonobject = response.then().contentType(ContentType.JSON).extract().asString();
		System.out.println(jsonobject);
		//ArrayList<Map<String,?>> jsonAsArrayList = from(jsonobject).get("");
	}
}
