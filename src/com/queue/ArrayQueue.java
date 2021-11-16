package com.queue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ArrayQueue{
	public static void main(String[] args) throws FileNotFoundException, QueueUnderflowException {
		Queue queueFixed = new Queue();  //Create a new array based Fixed queue
		Queue queueFloating = new Queue(); // Creating a new array fir floating queue
		try{ 
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

				//Pushing employee details to fixed queue
				queueFixed.enqueue(employee);

				//Pushing Employee details to Floating queue
				queueFloating.enqueue_float(employee);
			}
			sc.close();
		}
		catch(QueueOverflowException e) {
			System.out.println("Array not large enough!");	
		}
		System.out.println("---Employee Details in Fixed queue---");
		System.out.println(queueFixed); 
		queueFixed.dequeue();
		queueFixed.dequeue();
		System.out.println("---Employee Details in Fixed queue after dequeue---");
		System.out.println(queueFixed); 
		System.out.println();
		System.out.println("---Employee Details in Floating queue--");
		System.out.println(queueFloating); 
		queueFloating.dequeue_float();
		queueFloating.dequeue_float();
		System.out.println(queueFloating);
	}
}

//Creating an exception for Queues that go above the allowed space
class QueueOverflowException extends Exception {} 

//Creating an exception for Queues that try to access elemetns when none exist
class QueueUnderflowException extends Exception {}

//An array based implementation of a Queue
class Queue {
	protected Employee[] names; //array of the queue
	protected int front; //pointer to the front element of queue
	protected int end; //pointer to end element of the queue
	protected int numelements = 0; // number of elements in the queue
	//ArrayQueue constuctor
	public Queue() {  
		names = new Employee[40];
		front = 0;
		end = -1;
	}

	//Dequeue with a fixed-front design
	public Employee dequeue() throws QueueUnderflowException{
		if(numelements == 0) {
			throw new QueueUnderflowException();
		}
		//Get the front of the queue
		Employee return_item = names[front];
		//Move all elements over by 1
		for(int i=0;i<numelements;i++) {
			names[i] = names[i+1];
		}
		//Fix pointers and size
		end--;
		numelements--;
		return return_item;
	}

	//Equeue with a fixed-front design
	public void enqueue(Employee item) throws QueueOverflowException{
		if(numelements == names.length) {
			throw new QueueOverflowException();
		}
		//Put a new element onto the end of the list
		end++;
		names[end] = item;
		numelements++;
	}

	//Enqueue with a floating-front design
	public void enqueue_float(Employee item) throws QueueOverflowException {
		if(numelements == names.length) {
			throw new QueueOverflowException();
		}
		//Put a new element onto the end of the list
		end = (end+1)%names.length;
		names[end] = item;
		numelements++;
	}

	//Dequeue with a Floating-front design
	public Employee dequeue_float() throws QueueUnderflowException{
		if(numelements == 0) {
			throw new QueueUnderflowException();
		}
		//Get the front element, then fix the pointers
		Employee return_item = names[front];
		names[front] = null;
		front = (front+1)%names.length;
		numelements--;
		return return_item;

	}
	@Override
	public String toString() {
		String output = "";
		//Fix the toString method to work with fixed front and floating front designs
		for(int i=0;i<numelements;i++) {
			output = output+names[i]+"\n";
		}
		return output;
	}
}

class Employee {

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