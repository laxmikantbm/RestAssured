package com.testcases.rest;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.objects.rest.Base;
import com.objects.rest.FundTransfer;
import com.objects.rest.Login;
import com.objects.rest.VerifyAccount;
import com.objects.rest.VerifyLogout;

public class TestRest extends Base {
	
	
	

	public String authKey2 ;
	
	//Perform Login and Validation
	@Test(priority=1)
	public void loginVerify(){
		
		ExtentTest test = extent.createTest("Login and Verify");
		Login l1 = new Login();
		l1.login();
		test.info("User login successfuly !, Authorization key Generated");
		authKey2 = l1.login(); //Here the acquired key has been assigned to a variable so that it can be passed to other methods !
		test.info("Authorization key initialized to authKey2 variable ");
		l1.verifyLogin();
		extent.flush();
	}
	
	
	
	//Verify Account Details and Fetch
	@Test(priority=2)
	public void accountDetails(){
		ExtentTest test = extent.createTest("Verify Account Details ");
		VerifyAccount va = new VerifyAccount();
		va.verifyAccnt(authKey2);
		test.info("Account verified");
		va.viewAccInfo(authKey2,"800002");
		test.info("Account details fetched and using account ID");
		extent.flush();
	}
	
	
	//Verify the Transaction between two accounts
	@Test(priority=3)
	public void fundTranfer() {
		ExtentTest test = extent.createTest("Funds Transfer");
		FundTransfer ft= new FundTransfer();
		test.info("Initating Fund transfer");
		ft.fTransfer(authKey2);
		test.info("Funds trasfer is successfull between two accounts");
		test.log(Status.INFO, "Success");
		extent.flush();
	}

	
	@Test(priority=4)
	public void logOut() throws Exception {
		ExtentTest test = extent.createTest("Verify Logout");
		VerifyLogout lg= new VerifyLogout();
		lg.logOut();
		test.info("User Loged out");
		Thread.sleep(2000);
		test.info("Attempting to login");
		lg.verifyOut();
		test.info("User Logout verified");
		extent.flush();
	}
	
}
