package com.insurance.util;

import java.util.Comparator;

import com.insurance.InsuranceDetails;

public class CustomComparatorForSal implements Comparator{

	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		InsuranceDetails insurance1 = (InsuranceDetails) o1;
		InsuranceDetails insurance2 = (InsuranceDetails) o2;
		
		int sal1 = Integer.parseInt(insurance1.getAssureAmmount());
		int sal2 = Integer.parseInt(insurance2.getAssureAmmount());
		if(sal1 == sal2)
			return 0;
		else if(sal1 < sal2)
			return 1;
		else
			return -1;
		
	
	}
	

}
