package restAPI;

import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestWithFile {
	@Test
	public void test1() {
	
		 RestAssured.baseURI = "http://localhost:3000/employees";
		byte[] dataFule = Files.readALLBytes(Paths.get("data.json"));
		 
		 RequestSpecification request = RestAssured.given();
		
		Response response = request.contentType(ContentType.JSON)
									.accept(ContentType.JSON)
									.body(dataFile)
									.post("/create");
		
		String body = response.getBody().asString();
		System.out.println("Response body is " + body);
		System.out.println("Response code is " + response.statusCode());
		
		Assert.assertEquals(response.statusCode(), 201);
		
		

}
}