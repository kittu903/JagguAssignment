package com.date;

public class MainClassDate {
	public static void main(String[] args){
		try {
			SafeDate safeDate = new SafeDate(10, 30, 1000);
			System.out.println("Date (mm/DD/YYYY):"+safeDate.toString());

			System.out.println("Days To Add from 1/1/0 : "+safeDate.getDaysToAD()+" days");
			
			System.out.println("Days form this day to sepecified Date :"+safeDate.getDaysToDate(12,31, 2010)+" days");
			
			System.out.println("Is Between Date "+safeDate.isBetween(10, 10, 500, 10, 10, 2021));
			
			IncDate incDate = new IncDate(10, 30, 1000);
			incDate.increment();
			System.out.println("increment date "+incDate.toString());
			incDate.reduction();
			System.out.println("Reduction date "+ incDate.toString());
		}catch (DateOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}
}
