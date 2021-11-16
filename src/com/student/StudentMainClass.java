package com.student;

import java.util.Scanner;

public class StudentMainClass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//Creating Student Class Object and taking input form user
		Student student1 = new Student();
		System.out.println("Enter Student ID");
		student1.setId(sc.nextInt());
		sc.nextLine(); // Consume newline left-over
		System.out.println("Enter Student Name");
		student1.setName(sc.nextLine());
		
		//calling toString() from student class.
		System.out.println("Student Details : "+student1.toString());
		
		//Creating Student Class Object and taking input form user
		Student student2 = new Student();
		System.out.println("Enter Student ID");
		student2.setId(sc.nextInt());
		sc.nextLine(); // Consume newline left-over
		System.out.println("Enter Student Name");
		student2.setName(sc.nextLine());

		//calling toString() from student class.
		System.out.println("Student Details : "+student2.toString());
		
		System.out.println();
		
		//Comparing Both Student Objects
		System.out.println(student1.comapareTo(student2));
		
		sc.close();
	}
}
