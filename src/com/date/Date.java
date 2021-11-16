package com.date;

public class Date
{
  protected int year, month, day;

  public Date(int newMonth, int newDay, int newYear)
  {
    month = newMonth;  day = newDay;  year = newYear;
   }

  public int getYear() { 
	return year;  
  }
  public int getMonth(){ 
	return month; 
  }
  public int getDay(){ 
	return day;
  }
  
  
  // return true if this year is a leap year, otherwise, return false
  public boolean isLeapYear(){
	  if (year % 4 == 0) {

	      // if the year is century
	      if (year % 100 == 0) {

	        // if year is divided by 400
	        // then it is a leap year
	        if (year % 400 == 0)
	          return true;
	        else
	        	return false;
	      }
	      
	      // if the year is not century
	      else
	    	  return true;
	    }
	    
	    else
	    	return false;
  }
  
  // calculate the number of days from this date to AD (1/1/0), and return the number of days. 
  // e.g. result of getDaysToAD(1,2,0) is 1.
  public int getDaysToAD(){
	  int days=0;
	  
	  //Calculating No of leap years from 0 to current year
	  int noOfLeapYears= ((this.year-1)/4)-((this.year-1)/100)+((this.year-1)/400);
	  
	  
	  int nonLeapYears= this.year-noOfLeapYears;
	  
	  days+=(nonLeapYears*365)+(noOfLeapYears*365);
	  
	  //Based on Month and leap year adding no of days.
	  for(int i=1;i<this.month-1;i++) {
		 if(i==2) {
			 if(isLeapYear()) days+=29;
			 else days+=28;
		 }else {
			 if(i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) days+=31;
			 else days+=30;
		 }
	  }
	  
	  days+=this.day-1;
	  return days;
  }
  
  // check if this date is between two other given dates (exclusive). 
  // E.g. either 2/5/2020 of 2/15/2020 is not between 2/5/2020 and 2/15/2020
  // Hint: it might save your effort if you use the getDaysToAD function
  public boolean isBetween(int month1, int day1, int year1, int month2, int day2, int year2){
	  Date date1 = new Date(month1, day1, year1);
	  Date date2 = new Date(month2, day2, year2);
	  
	  int days1=date1.getDaysToAD();
	  int days2 = date2.getDaysToAD();
	  
	  int days = getDaysToAD();
	  if(days1>days2) {
		  if(days1-days >0 && days2-days<0) return true;
		  else return false;
	  }else {
		  if(days2-days>0 && days1-days<0) return true;
		  else return false;
	  }
  }
  
  // calculate the number of days from this date to an specifed date, and return the number of days.
  // E.g. 2/5/2020 to 2/15/2020 is 10; 2/15/2020 to 2/8/2020 is 7;
  // Hint: you might get help from getDaysToAD function
  public int getDaysToDate(int newMonth, int newDay, int newYear){
	Date date1 = new Date(newMonth, newDay, newYear);
	
	int days = getDaysToAD();
	int days1= date1.getDaysToAD();
	
	return days1-days;
  }
  
  // Returns this date as a String in formate of month/day/year. E.g. 02/05/2020
  public String toString(){
	return(month + "/" + day + "/" + year);
  }
}