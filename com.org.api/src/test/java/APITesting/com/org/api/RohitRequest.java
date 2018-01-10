package APITesting.com.org.api;

import javax.annotation.meta.When;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;

import static com.jayway.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.HashMap;

public class RohitRequest {

	@Test
	public void test_1() {
		Response response = when().get("http://api.openweathermap.org/data/2.5/weather?q=London,uk&appid=f66ddd488e48ba7a64726d63fb10624c");
		System.out.println(response.getStatusCode());
		ResponseBody values = response.getBody();
		System.out.println(values.asString());
		if (response.getStatusCode() == 200) {
			Assert.assertEquals(response.getStatusCode(), 200);
		}
		String weathervalues = values.asString();
		System.out.println(weathervalues);
		System.out.println(values);
		Response response1 = given().parameter("id", "2172797").parameter("appid", "f66ddd488e48ba7a64726d63fb10624c").when().get("http://api.openweathermap.org/data/2.5/weather");
		System.out.println(response1.getStatusCode());
		System.out.println("lets what is the response "+response1.getBody().asString());
		System.out.println(response1.then().contentType(ContentType.JSON).extract().path("base"));

	}

	@Test
	public void test_2() {
		Response response = when().get(
				"http://api.openweathermap.org/data/2.5/weather?q=London,uk&appid=f66ddd488e48ba7a64726d63fb10624c");
		if(response.getStatusCode()==200){
			HashMap weatherlist = response.then().contentType(ContentType.JSON).extract().path("weather[0]");
			System.out.println(weatherlist.size());
			System.out.println("weather is:" + weatherlist.get("description"));
			if(weatherlist.get("description").toString().equalsIgnoreCase("light rain")){
				System.out.println("test case passed");
			}else{
				System.out.println("test case fails");
			}
			
		}
		
		
		
		
		HashMap weatherlist1 = response.then().contentType(ContentType.JSON).extract().path("sys");
		System.out.println(weatherlist1.get("type"));
		
		
		

	}

}
