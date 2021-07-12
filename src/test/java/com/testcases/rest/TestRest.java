package com.testcases.rest;

import org.testng.annotations.Test;

import com.objects.rest.Base;
import com.objects.rest.FundTransfer;
import com.objects.rest.Login;
import com.objects.rest.VerifyAccount;
import com.objects.rest.VerifyLogout;

public class TestRest extends Base {
	
	
	//Perform Login and Validation
	public String authKey2 ;
	@Test(priority=1)
	public void loginVerify(){
		
		Login l1 = new Login();
		l1.login();
		authKey2 = l1.login();
		l1.verifyLogin();
	}
	
	
	
	//Verify Account Details and Fetch
	@Test(priority=2)
	public void accountDetails(){
		VerifyAccount va = new VerifyAccount();
		va.verifyAccnt(authKey2);
		va.viewAccInfo(authKey2,"800002");
	}
	
	
	//Verify the Transaction between two accounts
	@Test(priority=3)
	public void fundTranfer() {
		FundTransfer ft= new FundTransfer();
		ft.fTransfer(authKey2);
	}

	@Test(priority=4)
	public void logOut() {
		VerifyLogout lg= new VerifyLogout();
		lg.logOut();
	}
	
}
