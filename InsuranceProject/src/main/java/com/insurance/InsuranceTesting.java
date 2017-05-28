package com.insurance;

import java.util.Scanner;

import com.insurance.util.InsuranceDetailsUtilClass;

public class InsuranceTesting {

	public static void main(String[] args) {
		String fileName = "src//main//resources//insuranceDetailsFormate.txt";
		// create the InsuranceDetailsUtilClass object and call the required
		// method
		InsuranceDetailsUtilClass insuranceDetails = new InsuranceDetailsUtilClass();
		insuranceDetails.getInsuranceDetails(fileName);

		System.out.println("================================");
		System.out.println("Enter Polocy Type");
		Scanner s= new Scanner(System.in);
		

		String[] customerDetails = insuranceDetails.getTopFiveCustomers(
				fileName, s.next().toUpperCase());
		if (customerDetails != null) {
			for (int i = 0; i < customerDetails.length; i++) {
				if (customerDetails[i] != null)
					System.out.println(customerDetails[i]);
			}
		}

	}

}
