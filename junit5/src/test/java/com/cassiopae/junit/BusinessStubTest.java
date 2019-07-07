package com.cassiopae.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.cassiopae.junit.business.BusinessImpl;
import com.cassiopae.junit.service.DataService;

class DataServiceStub implements DataService {

	@Override
	public int[] retrieveAllData() {

		return new int[] { 1, 2, 3 };
	}

}

class DataServiceEmptyStub implements DataService {

	@Override
	public int[] retrieveAllData() {

		return new int[] {};
	}

}

public class BusinessStubTest {

	@Test
	public void calculateSumUsintDataService_basic() {
		BusinessImpl business = new BusinessImpl();
		business.setDataService(new DataServiceStub());
		int actualResult = business.calculateSumUsintDataService();
		int expectedResult = 6;

		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void calculateSumUsintDataService_empty() {
		BusinessImpl business = new BusinessImpl();
		business.setDataService(new DataServiceEmptyStub());
		int actualResult = business.calculateSumUsintDataService();
		int expectedResult = 0;

		assertEquals(expectedResult, actualResult);
	}
}


// That is we have to create many stubs according the Data  , which is not the good solution . So here the concept comes of the Mocking.
// With mocks you can create programatically create class
// and one more point we didnt want our junit to connect to the database. It will dependent on the data and  results will be affected.