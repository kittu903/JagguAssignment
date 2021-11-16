package com.customListImplementation;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;


public class CS401ArrayImpl<T> {

	private int elementsInArray=0;;

	private Object[] array = new Object[10];

	private T t;

	public void add(T t) {
		this.t=t;
		if(elementsInArray+1>array.length) {
			array = Arrays.copyOf(array, elementsInArray*2);
			System.out.println("array size Increased :"+array.length);
		}
		array[elementsInArray] = this.t;
		elementsInArray++;
	}

	public Object get(int i) {
		if(i<array.length) {
			return array[i];
		}else throw new IndexOutOfBoundsException("index :"+i);
	}

	public String toString(){
		String combinedArrayValues="";
		for(Object ob:array){
			if(ob!=null){
				combinedArrayValues=combinedArrayValues+ob+',';
			}
		}
		String temp1=combinedArrayValues.substring(0, combinedArrayValues.length()-1);
		return "["+temp1+"]";
	}

	public static void main(String[] args) {
		try {
			CS401ArrayImpl<Employee> arrayList = new CS401ArrayImpl<Employee>();

			//File path location of emp.txt (copy and paste your emp.txt file path)
			String path = "C:\\Users\\kittu\\OneDrive\\Desktop\\Java-WorkSpace\\JavaPractice\\JagguAssignment\\src\\com\\DataStructure\\emp.txt";

			//Reading the file
			FileInputStream fis=new FileInputStream(path); 

			Scanner sc=new Scanner(fis);    //file to be scanned
			//returns true if there is another line to read  

			while(sc.hasNextLine()){
				//Split the Line into array of string which matches space 
				String[] employeeDetails = sc.nextLine().split(" ");
				Employee employee = new Employee(employeeDetails[0], Long.valueOf(employeeDetails[1]));

				//Pushing employee details to arrayList
				arrayList.add(employee);
			}
			sc.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
