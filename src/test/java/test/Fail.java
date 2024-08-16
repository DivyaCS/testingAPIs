package test;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Fail {
	@Test
	public void testGetPost() {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		given()
		.header("Content-Type", "application/json")
		.when()
		.get("/posts/1")
		.then()
		.assertThat()
		.statusCode(400);
		System.out.println("Fail");
	}
}
