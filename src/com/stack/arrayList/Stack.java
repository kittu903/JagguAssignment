package com.stack.arrayList;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Stack {
	List<Employee> employeeList = new ArrayList<Employee>();
	
	@Override
	public String toString() {
		return "Stack [employeeList=" + employeeList + "]";
	}
	
	//that returns the Object at the top most element of the stack without deleting that element from the stack
	public Employee peek() {
		if (employeeList.isEmpty()) {
			return null;
		}
		return employeeList.get(employeeList.size() - 1);
	}
	
	//Removes the Object presents at the top
	public Employee pop() {
		if (employeeList.isEmpty()) {
			return null;
		}
		Employee top = employeeList.get(employeeList.size() - 1);
		employeeList.remove(employeeList.size() - 1);
		return top;
	}
	
	//Add Object to the top 
	public void push(Employee employee) {
		employeeList.add(employee);
	}
	
	public static void main(String[] args) {
		try {
			Stack stack = new Stack();
			//File path location of emp.txt (copy and paste your emp.txt file path)
			String path = "C:\\Users\\kittu\\OneDrive\\Desktop\\Java-WorkSpace\\JavaPractice\\JagguAssignment\\src\\com\\stack\\arrayList\\emp.txt";
			
			//Reading the file
			FileInputStream fis=new FileInputStream(path); 
			
			Scanner sc=new Scanner(fis);    //file to be scanned
			//returns true if there is another line to read  
			while(sc.hasNextLine()){
				//Split the Line into array of string which matches space 
				String[] employeeDetails = sc.nextLine().split(" ");
				Employee employee = new Employee(employeeDetails[0], Long.valueOf(employeeDetails[1]));
				
				//Pushing employee details to stack
				stack.push(employee);
			}
			
			System.out.println("Stack Top element : "+stack.peek());
			stack.pop();
			stack.pop();
			stack.peek();
			System.out.println("Stack Top element : "+stack.peek());
			sc.close();    
		}  
		catch(IOException e)  {  
			e.printStackTrace();  
		}  
	}
}
