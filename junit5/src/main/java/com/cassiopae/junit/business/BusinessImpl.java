package com.cassiopae.junit.business;

import com.cassiopae.junit.service.DataService;

public class BusinessImpl {

	private DataService dataService;

	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}

	public int calculateSum(int[] data) {
		int sum = 0;
		for (int value : data) {
			sum += value;
		}

		return sum;
	}

	public int calculateSumUsintDataService() {
		int sum = 0;
		int[] data = dataService.retrieveAllData();

		for (int value : data) {
			sum += value;
		}

		return sum;
	}
}
