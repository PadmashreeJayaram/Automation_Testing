package com.sample.api;


import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.junit.Assert.assertEquals;

public class RequestResponse {

	@Test
	public void getUsers() {
		RestAssured.baseURI = "https://reqres.in/"; 
		
		Response response= RestAssured.given()
							.queryParam("page", "2").
							when().get("api/users");
		
		System.out.println(response.prettyPrint());//printing the response body
		
		assertEquals(response.getStatusCode(),200);
		assertEquals(response.body().jsonPath().get("page").toString(),"2");		

	}
	
	@Test
	public void getSingleUser() {
		RestAssured.baseURI = "https://reqres.in/"; 
		
		Response response= RestAssured.given().
							when().get("api/users/2");
		
		System.out.println(response.prettyPrint());//printing the response body
		
		assertEquals(response.getStatusCode(),200);
		assertEquals(response.body().jsonPath().get("data.first_name").toString(),"Janet");		

	}
	@Test
	public void postCreateUser() {
		RestAssured.baseURI = "https://reqres.in/"; 
		
		String payload="{\n"
				+ "    \"name\": \"morpheus\",\n"
				+ "    \"job\": \"leader\"\n"
				+ "}";
		
		Response response= RestAssured.given().header("Content-Type","application/json").body(payload).
							when().post("api/users");
		
		System.out.println(response.prettyPrint());//printing the response body
		
		assertEquals(response.getStatusCode(),201);
		assertEquals(response.body().jsonPath().get("name").toString(),"morpheus");	//verify user name
		assertEquals(response.body().jsonPath().get("job").toString(),"leader");//verify user job
	}
}
