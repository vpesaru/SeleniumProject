package com.amazon.api.tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import com.amazon.helpers.EmployeeServiceHelper;

public class TestDeleteEmployee {
	private static final String BASE_URL = EndPoints.BASE_URL;

	// Deleting an employee and validate the status code & successful message
	@Test
	public void getStatusCode() {
		// System.out.println(BASE_URL);
		RestAssured.baseURI = EndPoints.BASE_URL;
		given().when().delete(EndPoints.DELETE_SINGLE_EMPLOYEE).then().log().all().assertThat().statusCode(200)
				.body("message", equalTo("Successfully! Record has been deleted"));

	}

}
