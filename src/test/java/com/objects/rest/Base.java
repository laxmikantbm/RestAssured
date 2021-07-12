package com.objects.rest;

import org.testng.annotations.BeforeTest;

import io.restassured.RestAssured;

public class Base{
	
	private String baseUri = "https://demo.testfire.net/api";
	
	@BeforeTest
	public void setup() {
		RestAssured.baseURI = baseUri;
		RestAssured.useRelaxedHTTPSValidation();
		
	}
	
	
	
}
