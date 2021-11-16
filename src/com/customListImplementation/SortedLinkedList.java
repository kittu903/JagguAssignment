package com.customListImplementation;

import java.io.FileInputStream;
import java.util.Scanner;

public class SortedLinkedList<T> extends LinkedList<Employee>{
	
	public SortedLinkedList(LinkedList<Employee> linkedList) {
		this.head=linkedList.head;
		this.sortList();
	}

	public void sortList() {  
        //Node current will point to head  
        Node<Employee> current = this.head, index = null;  
        Employee temp;  
          
        if(this.head == null) {  
            return;  
        }  
        else {  
            while(current != null) {  
                index = current.next;  
                while(index != null) {  
                    if(current.data.getId() > index.data.getId()) {  
                        temp = current.data;  
                        current.data = index.data;  
                        index.data = temp;  
                    }  
                    index = index.next;  
                }  
                current = current.next;  
            }      
        }  
    } 
	
	public static void main(String[] args) {
		try {
			LinkedList<Employee> linkedList = new LinkedList<Employee>();

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
				linkedList.add(employee);
			}
			linkedList.printList();
			
			SortedLinkedList<Employee> sortedLinkedList = new SortedLinkedList<Employee>(linkedList);
			System.out.println("Linked List After sorting");
			sortedLinkedList.printList();

			sc.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
