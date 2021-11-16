package com.stack.arrayList;

public class Employee {

	private long id;

	private String name;

	public void setId(int id) {
		this.id=id;
	}

	public long getId() {
		return this.id;
	}

	public void setName(String name) {
		this.name=name;
	}

	public String getName() {
		return this.name;
	}

	public String toString() {
		return " ( Name : "+this.name+", ID : "+this.id+" )";
	}
	
	public Employee(String name, long id) {
		this.name=name;
		this.id=id;
	}

}
