package com.objects.rest;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.testng.Assert;

public class VerifyLogout extends Login  {
	
	
	public void logOut() {
	
	 Response logout=given().
                     when().
                           get("/logout").
                     then().
                           assertThat().statusCode(200).
                           extract().response();
	 
	    String lgout =logout.path("LoggedOut").toString(); 
	    Assert.assertEquals(lgout,"True");
	    
	    System.err.println("Logout Successfull !\n");
	    System.out.println("////////////////////////////////////////////////\n");
	}
	



public void verifyOut() {
	Response logIn=given()
            .auth().oauth2(login()).
     when()
            .get("/login").
     then()
            .assertThat().statusCode(200).
             extract().response();

String logiin=logIn.path("loggedin").toString();

Assert.assertEquals(logiin, "true");

System.err.println("User logout verified !\n");
System.out.println("////////////////////////////////////////////////\n");

	
}
}