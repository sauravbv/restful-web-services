package getAssured;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.internal.assertion.Assertion;
import io.restassured.response.Response;

public class testAssured {

	
	public void testData() {
		
		Response resp = RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?id=2172797&appid=b6907d289e10d714a6e88b30761fae22");
		
		int code = resp.getStatusCode();
		
		System.out.println("Status code is" +code);
		
		Assert
		
		
		
		
	}
}
