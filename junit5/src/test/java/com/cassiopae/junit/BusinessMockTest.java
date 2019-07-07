package com.cassiopae.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cassiopae.junit.business.BusinessImpl;
import com.cassiopae.junit.service.DataService;

public class BusinessMockTest {
	
	BusinessImpl business = new BusinessImpl();
	DataService dataServiceMock = mock(DataService.class);
	
	@BeforeEach
	public void before()
	{
//		System.out.println("business instance static as it is non-static for dynamic input");
		business.setDataService(dataServiceMock);
	}
	
	@Test
	public void calculateSumUsintDataService_basic() {
		
		// Instead of - dataServiceMock retrieveAllData new int[] {1,2,3}; we will do
		// that programmatically

		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 1, 2, 3 });
//		business.setDataService(dataServiceMock);
		assertEquals(6, business.calculateSumUsintDataService());
	}

	@Test
	public void calculateSumUsintDataService_empty() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
//		business.setDataService(dataServiceMock);
		assertEquals(0, business.calculateSumUsintDataService());
	}
	
	@Test
	public void calculateSumUsintDataService_oneValue() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {5});
//		business.setDataService(dataServiceMock);
		assertEquals(5, business.calculateSumUsintDataService());
	}
}

// That is we have to create many stubs according the Data , which is not the
// good solution . So here the concept comes of the Mocking.
// With mocks you can create programatically create class
// and one more point we didnt want our junit to connect to the database. It
// will dependent on the data and results will be affected.