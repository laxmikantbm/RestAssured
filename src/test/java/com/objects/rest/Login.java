package com.objects.rest;
import org.testng.Assert;

import com.variables.rest.VariableRepo;

import io.restassured.http.ContentType;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Login extends VariableRepo {
	
       
	
	
	//This method will login user and generates and return the Authorization key
	public String login() {
		Response res = given()
				             .body(creds).accept(ContentType.JSON).
		               when()
		                     .post("/login").
		               then().
		                     assertThat().statusCode(200).
		                     extract().response();
		
		String authKey = res.path(auth.toString());
		
	    return authKey;
	}
	
	//Verify the user if he has logged in by passing the authorization key
	public void verifyLogin() {
	Response logIn=given()
			              .auth().oauth2(login()).
		           when()
		                  .get("/login").
		           then()
		                  .assertThat().statusCode(200).
		                   extract().response();
	
	    String logiin=logIn.path("loggedin").toString();
	    
	    Assert.assertEquals(logiin, "true");
	    
	    
		System.out.println("////////////////////////////////////////////////\n");
		System.err.println("       Authorization Key Accquired  \n");
		System.out.println(login()+"\n");
		System.out.println("////////////////////////////////////////////////\n");
		System.err.println("User Login Verified ! \n");
			
		
	}
	
	

}
