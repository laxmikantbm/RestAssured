package com.objects.rest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.variables.rest.VariableRepo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Login extends VariableRepo {
	
       
	
	
	
	public String login() {
		Response res = given().body(creds).accept(ContentType.JSON).
		when().post("/login").
		then().assertThat().statusCode(200).extract().response();
		String authKey = res.path(auth.toString());
		
	    return authKey;
	}
	
	public void verifyLogin() {
	Response logIn=given().auth().oauth2(login()).
		when().get("/login").
		then().assertThat().statusCode(200).extract().response();
	    String logiin=logIn.path("loggedin").toString();
	    Assert.assertEquals(logiin, "true");
	    
		System.out.println("////////////////////////////////////////////////\n");
		System.err.println("       Authorization Key Accquired  \n");
		System.out.println(login()+"\n");
		System.out.println("////////////////////////////////////////////////\n");
		System.err.println("User Login Verified ! \n");
		
		
	}
	
	

}
