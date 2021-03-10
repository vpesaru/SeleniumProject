package com.amazon.api.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import java.lang.reflect.Type;
import java.util.List;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.amazon.constants.EndPoints;
import com.amazon.model.Employee;
import com.amazon.utils.ConfigManager;
import com.fasterxml.jackson.core.type.TypeReference;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import com.amazon.helpers.EmployeeServiceHelper;

public class TestGetEmployee_Examples {
	private static final String BASE_URL = EndPoints.BASE_URL;

	@BeforeTest
	public void URL() {
		RestAssured.baseURI = EndPoints.BASE_URL;
	}

	// Retrieving the data for all the employees and validate the status code &
	// successful message
	@Test
	public void getStatusCodeForAllEmployees() {
		given().when().get(EndPoints.GET_ALL_EMPLOYEES).then().log().all().assertThat().statusCode(200).body("message",
				equalTo("Successfully! All records has been fetched."));

	}

	// Retrieving the data for a Single employees
	@Test
	public void getStatusCodeForSingleEmployee() {
		given().when().get(EndPoints.GET_SINGLE_EMPLOYEE).then().log().all().assertThat().statusCode(200)
				.body("message", equalTo("Successfully! Record has been fetched."));

	}

}
