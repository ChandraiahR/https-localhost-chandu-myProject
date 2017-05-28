package com.insurance.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.insurance.FindNumberOfDays;
import com.insurance.InsuranceDetails;

public class InsuranceDetailsUtilClass {
	public void getInsuranceDetails(String fileName) {

		try {

			BufferedReader br = new BufferedReader(new FileReader(fileName));

			// create three list classsess for three polocyTypes MB,VB,HB
			List<InsuranceDetails> mBDelayInsurance = new ArrayList<InsuranceDetails>();
			List<InsuranceDetails> hPDelayInsurance = new ArrayList<InsuranceDetails>();
			List<InsuranceDetails> vHDelayInsurance = new ArrayList<InsuranceDetails>();

			List<InsuranceDetails> mBOnTimeInsurance = new ArrayList<InsuranceDetails>();
			List<InsuranceDetails> hPOnTimeInsurance = new ArrayList<InsuranceDetails>();
			List<InsuranceDetails> vHOnTimeInsurance = new ArrayList<InsuranceDetails>();

			// create 2- list types one for paymenyDelay and one for
			// paymentIntime

			// create one List object for Duplicates Insurance Details
			List<InsuranceDetails> duplicateDetails = new ArrayList<InsuranceDetails>();
			List<InsuranceDetails> invalidDetails = new ArrayList<InsuranceDetails>();

			// create the set type object to remove the same policyType with
			// same AccountNumber types
			Set removeDublic = new LinkedHashSet();

			String fileData = null;
			while ((fileData = br.readLine()) != null) {
				// split the data into required Formate
				String[] strData = fileData.split(",");
				String[] payDetails = strData[0].split("-");
				String[] modelPol = payDetails[1].split("/");

				// add the values to understanding formate
				String policyType = payDetails[0].trim();
				String modeofPolicy = modelPol[0].trim();
				String polocyNumber = modelPol[1].trim();
				String datOfPolocyStarted = payDetails[2].trim();
				String custName = strData[1].trim();
				String assureAmmount = strData[2].trim();
				String payDate = strData[3].trim();
				String dueDate = strData[4].trim();

				// check policyNumber is more than 4 are not
				if (polocyNumber.length() >= 4) {

					// create string obj for to remove the same PolicyType and
					// AccountType
					String dubLicatePolocy = policyType + polocyNumber;
					InsuranceDetails insurance = buildInsuranceObject(
							policyType, modeofPolicy, polocyNumber,
							datOfPolocyStarted, custName, assureAmmount,
							payDate);
					// Write the condition for to remove the duplicates
					if ("MB".equals(policyType) || "HP".equals(policyType)
							|| "VH".equals(policyType)
							|| "Y".equals(modeofPolicy)
							|| "Q".equals(modeofPolicy)
							|| "H".equals(modeofPolicy)) {
						// System.out.println(insurance);
						if (removeDublic.add(dubLicatePolocy)) {

							// set the values to the insurance Object

							// Call the static method of FindNumberOfDays class
							// to
							// find no-of days
							int noOfDays = FindNumberOfDays.findDays(payDate,
									dueDate);
							float fineAmount = 0;

							if ("Q".equals(modeofPolicy))
								fineAmount = (Float.parseFloat(assureAmmount) / (100 * 91))
										* noOfDays;
							else if ("H".equals(modeofPolicy))
								fineAmount = ((Float.parseFloat(assureAmmount) * 3) / (100 * 182))
										* noOfDays;
							else if ("Y".equals(modeofPolicy))
								fineAmount = ((Float.parseFloat(assureAmmount) * 5) / (100 * 365))
										* noOfDays;

							insurance.setFineAmount(fineAmount);

							if ("MB".equals(policyType)) {
								if (0 == noOfDays) {
									insurance.setFineAmount(0.0f);
									mBOnTimeInsurance.add(insurance);
								} else
									mBDelayInsurance.add(insurance);

							}

							else if ("VH".equals(policyType)) {
								if (0 == noOfDays) {
									insurance.setFineAmount(0.0f);
									vHOnTimeInsurance.add(insurance);
								} else
									vHDelayInsurance.add(insurance);
							} else if ("HP".equals(policyType)) {
								if (0 == noOfDays) {
									insurance.setFineAmount(0.0f);
									hPOnTimeInsurance.add(insurance);
								} else
									hPDelayInsurance.add(insurance);
							}

						} else {
							insurance.setFineAmount(0.0f);
							duplicateDetails.add(insurance);
						}
					} else {
						// System.out.println(insurance);
						insurance.setFineAmount(0.0f);
						invalidDetails.add(insurance);
					}

				}
			}

			Map<String, List<InsuranceDetails>> mBMap = new LinkedHashMap<String, List<InsuranceDetails>>();
			mBMap.put("ONTIME", mBOnTimeInsurance);
			mBMap.put("DELAY", mBDelayInsurance);

			Map<String, List<InsuranceDetails>> hPMap = new LinkedHashMap<String, List<InsuranceDetails>>();
			hPMap.put("ONTIME", hPOnTimeInsurance);
			hPMap.put("DELAY", hPDelayInsurance);

			Map<String, List<InsuranceDetails>> vHMap = new LinkedHashMap<String, List<InsuranceDetails>>();
			vHMap.put("ONTIME", vHOnTimeInsurance);
			vHMap.put("DELAY", vHDelayInsurance);

			Map<String, Map<String, List<InsuranceDetails>>> mainMap = new LinkedHashMap<String, Map<String, List<InsuranceDetails>>>();
			mainMap.put("MB", mBMap);
			mainMap.put("HP", hPMap);
			mainMap.put("VH", vHMap);
			
			System.out.println(mainMap);
			/*for (Map.Entry mainMapData : mainMap.entrySet()) {
				System.out
						.println("==========================================");
				System.out.println(mainMapData.getKey() + "  Details are :"
						+ "\n--------------------");
				Map<String, List<InsuranceDetails>> delayOrOntimeMap = (Map<String, List<InsuranceDetails>>) mainMapData
						.getValue();
				for (Map.Entry subMap : delayOrOntimeMap.entrySet()) {
					System.out.print(subMap.getKey() + "   ");
					System.out.println(subMap.getValue());
				}
				System.out
						.println("=============================================");
			}*/
System.out.println("=======================================================================");
			System.out.println("Duplicate Insurance details are:"
					+ "\n------------------------------"+"\n"+duplicateDetails);
			/*for (InsuranceDetails details : duplicateDetails)
				System.out.println(details.getPolicyType() + " " + details);*/

			System.out.println("================================="
					+ "\nInValidDetails are" + "\n------------------"+"\n"+invalidDetails);
			/*for (InsuranceDetails details : invalidDetails)
				System.out.println(details.getPolicyType() + " " + details);*/

		} catch (Exception e) {
			System.out.println("Exception occured" + e);
		}

	}

	/**
	 * @ReturnType InsuranceDetails
	 * @param policyType
	 * @param modeofPolicy
	 * @param polocyNumber
	 * @param datOfPolocyStarted
	 * @param custName
	 * @param assureAmmount
	 * @param payDate
	 * @return
	 */
	private InsuranceDetails buildInsuranceObject(String policyType,
			String modeofPolicy, String polocyNumber,
			String datOfPolocyStarted, String custName, String assureAmmount,
			String payDate) {
		InsuranceDetails insurance = new InsuranceDetails();
		insurance.setPolicyType(policyType);
		insurance.setModeofPolicy(modeofPolicy);
		insurance.setPolocyNumber(polocyNumber);
		insurance.setDatOfPolocyStarted(datOfPolocyStarted);
		insurance.setCustName(custName);
		insurance.setAssureAmmount(assureAmmount);
		insurance.setPayDate(payDate);
		return insurance;
	}

	// Top five customers method
	public String[] getTopFiveCustomers(String fileName, String polType) {
		String[] resp = null;
		try {
			String fileData = null;
			if ("HP".equals(polType) || "MB".equals(polType)
					|| "VH".equals(polType)) {

				Set duplicate = new LinkedHashSet();
				List<InsuranceDetails> listOfDetails = new ArrayList<InsuranceDetails>();

				BufferedReader br = new BufferedReader(new FileReader(fileName));
				while ((fileData = br.readLine()) != null) {

					// split the data into required Formate
					String[] strData = fileData.split(",");

					String[] payDetails = strData[0].split("-");
					String[] modelPol = payDetails[1].split("/");

					// add the values to understanding formate
					String policyType = payDetails[0].trim();

					String modeofPolicy = modelPol[0].trim();

					String polocyNumber = modelPol[1].trim();

					String datOfPolocyStarted = payDetails[2].trim();
					String custName = strData[1].trim();
					String assureAmmount = strData[2].trim();
					String payDate = strData[3].trim();
					String dueDate = strData[4].trim();
					if (polocyNumber.length() >= 4) {

						// create string obj for to remove the same PolicyType
						// and
						// AccountType
						String dubLicatePolocy = policyType + polocyNumber;
						InsuranceDetails insurance = buildInsuranceObject(
								policyType, modeofPolicy, polocyNumber,
								datOfPolocyStarted, custName, assureAmmount,
								payDate);

						// Write the condition for to remove the duplicates
						if (duplicate.add(dubLicatePolocy)) {
							if (polType.equals(policyType))
								listOfDetails.add(insurance);
						}
					}
				}
				Collections.sort(listOfDetails, new CustomComparatorForSal());
				int count = 0;
				resp = new String[listOfDetails.size()];
				// System.out.println(resp.length);
				for (InsuranceDetails details : listOfDetails) {
					if (count < 5) {
						System.out.println(details.getPolicyType() + " "
								+ details.getAssureAmmount() + " "
								+ details.getCustName());
						resp[count] = details.getCustName();
					}
					count++;
					/*
					 * System.out.println(details.getCustName());
					 * System.out.println(count); count++;
					 */
				}
				System.out.println("============");
				return resp;
			} else
				System.out.println("Please Enter Polocy Type is Valid Type like(MB,HP,VH)");
			return resp;
		} catch (Exception e) {
			e.printStackTrace();
			return resp;
		}

	}
}
