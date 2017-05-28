package com.insurance;

public class FindNumberOfDays {
	public static int findDays(String payDate, String dueDate) {

		String[] pDate = payDate.split("-");
		String[] dDate = dueDate.split("-");
		System.out.println();

		int day_of_pDate = Integer.parseInt(pDate[0]);
		int month_of_pDate = Integer.parseInt(pDate[1]);
		int year_of_pDate = Integer.parseInt(pDate[2]);

		int day_of_dDate = Integer.parseInt(dDate[0]);
		int month_of_dDate = Integer.parseInt(dDate[1]);
		int year_of_dDate = Integer.parseInt(dDate[2]);

		int noOfDays = 0;
		if (payDate.equals(dueDate)) {
			return noOfDays;
		} else if (year_of_pDate >= year_of_dDate) {

			if (day_of_pDate < day_of_dDate) {
				month_of_pDate = month_of_pDate - 1;
				day_of_pDate = day_of_pDate + 1 * 30;

			}
			if (month_of_pDate < month_of_dDate) {
				year_of_pDate = year_of_pDate - 1;
				month_of_pDate = month_of_pDate + 1 * 12;

			}
			int date = day_of_pDate - day_of_dDate;
			int month = month_of_pDate - month_of_dDate;
			int year = 0;

			if (year_of_pDate >= year_of_dDate) {
				year = year_of_pDate - year_of_dDate;
				noOfDays = year * 12 * 30 + month * 30 + date;
				return noOfDays;
			}

			else {
				return noOfDays;

			}

		} else {
			System.out.println("Main Error");
			return 0;
		}

	}
}
