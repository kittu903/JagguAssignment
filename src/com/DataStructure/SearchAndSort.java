package com.DataStructure;

import java.io.FileInputStream;
import java.util.Scanner;


public class SearchAndSort {

	public static void main(String[] args) {
		try {
			Employee[] employees =new Employee[30];
			//File path location of emp.txt (copy and paste your emp.txt file path)
			String path = "C:\\Users\\kittu\\OneDrive\\Desktop\\Java-WorkSpace\\JavaPractice\\JagguAssignment\\src\\com\\DataStructure\\emp.txt";

			//Reading the file
			FileInputStream fis=new FileInputStream(path); 

			Scanner sc=new Scanner(fis);    //file to be scanned
			//returns true if there is another line to read  
			int i=0;
			while(sc.hasNextLine()){
				//Split the Line into array of string which matches space 
				String[] employeeDetails = sc.nextLine().split(" ");
				Employee employee = new Employee(employeeDetails[0], Long.valueOf(employeeDetails[1]));

				//Pushing employee details to array
				employees[i] = employee;
				i++;
			}

			employees = selectionSort(employees);

			System.out.println("Enter the Employee id to search");
			Scanner searchScanner = new Scanner(System.in);
			long id = searchScanner.nextLong();
			int searchIdPosition = BinarySearch(employees, id);
			if(searchIdPosition>0)
				System.out.println("Employee Details are :"+employees[searchIdPosition]);
			else System.out.println("Employee details not found");
			searchScanner.close();
			sc.close();
		}catch (Exception e) {
		}
	}

	private static void display(Employee[] employees) {
		for(int i=0;i<employees.length;i++) {
			System.out.println(employees[i]);
		}
	}

	private static Employee[] selectionSort(Employee[] employees) {
		int size = employees.length;
		System.out.println("Before Selection sort");
		display(employees);
		for(int i=0;i<size-1;i++) {
			Employee employeeMinId = employees[i];
			int postionId = i;
			for(int j=i+1; j<size;j++) 
				if(employeeMinId.getId()>employees[j].getId()) {
					employeeMinId=employees[j];
					postionId=j;
				}
			employees[postionId]=employees[i];
			employees[i]= employeeMinId;
		}
		System.out.println();
		System.out.println("After Selection sort");
		display(employees);
		return employees;

	}

	//Binay search bu using empoyeeId
	private static int BinarySearch(Employee[] arr, long searchId) {
		int start = 0, end = arr.length - 1;
		while (start <= end) {
			int middle = start + (end - start) / 2;

			// Check if id is present at mid
			if (searchId==arr[middle].getId())
				return middle;

			// If id greater, ignore left half
			if (searchId > arr[middle].getId())
				start = middle + 1;

			// If id is smaller, ignore right half
			else
				end = middle - 1;
		}
		
		//If id not found in the list return -1
		return -1;
	}
}
