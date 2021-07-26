package com.objects.rest;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.restassured.RestAssured;

public class Base{
	
	private String baseUri = "https://demo.testfire.net/api";
	
	public ExtentReports  extent;
	
	@BeforeTest
	public void setup() {
		
		RestAssured.baseURI = baseUri;
		RestAssured.useRelaxedHTTPSValidation();
		
		
	
		ExtentSparkReporter reporter  = new  ExtentSparkReporter("Reports\\report.html");
		reporter.config().setDocumentTitle("Rest Assured");
		reporter.config().setReportName("Rest Assured Test Case");
		
		extent = new ExtentReports();
		
		extent.attachReporter(reporter);
		
		extent.setSystemInfo("Company Name", "Brillio");
		extent.setSystemInfo("Project Name", "Rest Assured automation testing");
        
		
	}
	
	
	
}
