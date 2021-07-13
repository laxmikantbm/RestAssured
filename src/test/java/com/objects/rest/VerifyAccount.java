package com.objects.rest;
import static io.restassured.RestAssured.*;
import org.testng.Assert;

import com.variables.rest.VariableRepo;

import io.restassured.response.Response;

public class VerifyAccount extends VariableRepo {
	
	
    //Verifies the user account 
	public void verifyAccnt(String key)  {
		Response accDetails = given()
				                    .auth().oauth2(key).
							  when()
							        .get(acnt).
							  then()
							        .assertThat().statusCode(200)
							        .extract().response();
		
		System.out.println("////////////////////////////////////////////////\n");
		
		//System.out.println(accDetails.path("Accounts.Name").toString());
		//System.out.println(accDetails.path("Accounts.id").toString()+"\n");
		
		String details = accDetails.path("Accounts.Name[0]").toString();
		Assert.assertEquals(details,"Savings");
		System.err.println("Account Details Verified !\n");
	}
	
	//This method will take Authorization key and Account number and gets the details of that account
	public void viewAccInfo(String key,String accntNo) {
		Response info=given()
				            .auth().oauth2(key).
					  when()
					        .get(acnt+accntNo).
					  then()
					        .assertThat().statusCode(200)
					        .extract().response();
		
		System.out.println("////////////////////////////////////////////////\n");
		String act=info.path("accountId").toString();
		Assert.assertEquals(act,"800002");
		System.err.println("Account Details Fetched for : "+"ID : "+ act+"\n");
		
		//System.out.println(info.asPrettyString());
	}
	
	
	

}
