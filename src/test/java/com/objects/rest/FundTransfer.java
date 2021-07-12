package com.objects.rest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.testng.Assert;

import com.variables.rest.VariableRepo;

public class FundTransfer extends VariableRepo {
	
	
	//This method takes Authorization key 
	public void fTransfer(String key) {
		Response res=given().auth().oauth2(key).contentType(ContentType.JSON).body(ftransfer).
		when().post("/transfer").
        then().assertThat().statusCode(200).extract().response();	
		String ft=res.path("success").toString();
		System.out.println("////////////////////////////////////////////////\n");
		Assert.assertEquals(ft,res.path("success"));
		System.err.println("Fund Transfer Successfull ! \n");
		//System.out.println(res.asPrettyString());
		System.out.println("////////////////////////////////////////////////\n");
	}

}
