package com.amazon.helpers;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

import java.lang.reflect.Type;
import java.util.List;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import com.amazon.constants.EndPoints;
import com.amazon.model.Employee;
import com.amazon.utils.ConfigManager;
import com.fasterxml.jackson.core.type.TypeReference;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class EmployeeServiceHelper {
	
	private static final String BASE_URL = ConfigManager.getInstance().getString("base_url");
	
	public EmployeeServiceHelper() {
		RestAssured.baseURI= BASE_URL;
	
	}
	
	public void getStatusCode(String endPoint,int statusCode, String message) {
		//System.out.println(BASE_URL);
		RestAssured.baseURI = EndPoints.BASE_URL;
		
		  given()
		 .when().get(endPoint)
		  .then().log().all().assertThat().statusCode(statusCode).body("message",equalTo(message));
		
	}
	
	@Test
	public List<Employee> getAllEmployees(){
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.get(EndPoints.GET_ALL_EMPLOYEES)
				.andReturn();
		Type type = new TypeReference<List<Employee>>(){}.getType();
		
		assertEquals(response.getStatusCode(),HttpStatus.SC_OK, "OK");
		//assertEquals(response.getStatusCode())
		List<Employee> employeeList = response.as(type);
		return employeeList;
	}
	
}
