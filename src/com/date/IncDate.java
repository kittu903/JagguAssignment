package com.date;

public class IncDate extends Date
{

	public IncDate(int newMonth, int newDay, int newYear)
	{
		super(newMonth, newDay, newYear);
	}

	// Increments this IncDate to represent the next day.
	public void increment(){

		//checking if date ranges between 0 and 28 then add 1 days and return
		if(this.day<28) {
			this.day+=1;
			return;
		}else {
			if(this.month==2) {
				if(isLeapYear() && this.day<29) {
					this.day+=1;
					return;
				}
				else {
					this.day=1;
					this.month+=1;
				}
			}else {
				if(this.day<30) {
					this.day+=1;
					return;
				}else {
					if(this.month == 1 || this.month == 3 || this.month == 5 || this.month == 7 || this.month == 8 || this.month == 10 || this.month == 12) {
						if(this.day==30) {
							this.day+=1;
							return;
						}else {
							this.day=1;
							this.month=1;
							if(this.month==12) {
								this.year+=1;
								return;
							}return;
							
						}
					}
					else {
						this.day=1;
						this.month+=1;
						return;
					}
				}
			}
		}
	}

	// reduce this IncDate to represent the previous day.
	public void reduction(){
		if(this.day>1) {
			this.day-=1;
			return;
		}else {
			this.month-=1;
			
			if(this.month==2) {
				if(this.isLeapYear()) {
					this.day=29;
					return;
				}else {
					this.day=28;
					return;
				}
			}else {
				if(this.month==0) {
					this.day=31;
					this.month=12;
					this.year-=1;
				}else {
					if(this.month==1 || this.month==3 || this.month==5 || this.month==7 || this.month==8 || this.month==10) {
						this.day=31;
						return;
					}else {
						this.day=30;
						return;
					}
				}
			}
		}
	}
}
