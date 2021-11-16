package com.date;

/* In this lab, you are required to implement a safe date class. 
If the year, month or day is invalid, a DateOutOfBoundsException will be thrown with appriate error message.
DateOutOfBoundsException is predefined. You don't need to make any modification of this class.
Hint: Please consider the following case.
1/45/2020, 1/13/-2020, 2/29/2019 */
public class SafeDate extends Date
{
	public SafeDate(int newMonth, int newDay, int newYear)
			throws DateOutOfBoundsException
	{
		super(newMonth, newDay, newYear);
		if(this.year>0) {
			if(this.month>0 && this.month<=12) {
				if(this.month==2) {
					if(this.isLeapYear() && this.day>29) throw new DateOutOfBoundsException(toString()+" invalid date, "+this.year+" is a leap year and February month has only 29 days");
					else if(this.day>28) throw new DateOutOfBoundsException(toString()+" is invalid date, "+this.year+" is not leap year and February month has only 28 days");
				}else {
					if(this.month == 1 || this.month == 3 || this.month == 5 || this.month == 7 || this.month == 8 || this.month == 10 || this.month == 12) {
						if(this.day>31) throw new DateOutOfBoundsException(toString()+" is invalid date, for this month date can't exceed 31");
					}else if(this.day>30) throw new DateOutOfBoundsException(toString()+" is invalid , for this month date can't exceed 30");
				}
			}else {
				throw new DateOutOfBoundsException(toString()+" is invalid date, month should be range from 1 to 12");
			}
		}else {
			throw new DateOutOfBoundsException(toString()+" is invalid date, Year should be always positive");
		}
	}
}

