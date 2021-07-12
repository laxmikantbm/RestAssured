package com.objects.rest;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.testng.Assert;

public class VerifyLogout  {
	
	
	public void logOut() {
	
	 Response logout=given().
        when().get("/logout").
        then().assertThat().statusCode(200).extract().response();
	    String lgout =logout.path("LoggedOut").toString(); 
	    Assert.assertEquals(lgout,"True");
	    System.err.println("Logout Successfull !\n");
	    System.out.println("////////////////////////////////////////////////\n");
	}
	

}
