package com.student;

public class Student{

	private int id;
	
	private String name;
	
	public void setId(int id) {
		this.id=id;
	}
	
	public int getId() {
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
	
	public String comapareTo(Student student) {
		if(this.name.equals(student.name)) {
			if(this.id==student.id) {
				return "Name and Id is Same for both Students.";
			}else return "Only Name is same for both Students.";
		} return "Name is Different for both Students.";
	}
}
