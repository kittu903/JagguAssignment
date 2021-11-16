package com.customListImplementation;

public class DoublyLinkedList {

	class Node{
		int data;
		Node previous;
		Node next;

		public Node(int data) {
			this.data=data;
		}
	}
	Node head, tail = null;

	public void add(int data) {
		 //Create a new node  
        Node newNode = new Node(data);  
   
        //if list is empty, head and tail points to newNode  
        if(head == null) {  
            head = tail = newNode;  
            head.previous = null;  
            tail.next = null;  
        }  
        else {  
            tail.next = newNode;  
            newNode.previous = tail;  
            tail = newNode;  
            tail.next = null;  
        }  
	}

	public void remove(int data) {
		Node current = head;
		Node nodeToDelete=null;
		if(head==null) {
			System.out.println("List is empty");  
			return;  
		}
		while(current != null) {
			if(current.next!=null && current.data==data) {
				nodeToDelete = current;
			}
			current= current.next;
		}
		
		if(nodeToDelete!=null)
			deleteNode(nodeToDelete);
	}
	
	public Boolean contains(int data) {
		Node current = head;
		Node nodeToDelete=null;
		if(head==null) {
			return Boolean.FALSE;  
		}
		while(current != null) {
			if(current.next!=null && current.data==data) {
				nodeToDelete = current;
			}
			current= current.next;
		}
		
		if(nodeToDelete!=null)
			return Boolean.TRUE;
		return Boolean.FALSE;
	}
	
	private Node deleteNode(Node nodeToDelete) {
		  if (head == null || nodeToDelete == null)
	            return null;
	 
	        if (head == nodeToDelete)
	            head = nodeToDelete.next;
	 
	        if (nodeToDelete.next != null)
	        	nodeToDelete.next.previous = nodeToDelete.previous;
	 
	        if (nodeToDelete.previous != null)
	        	nodeToDelete.previous.next = nodeToDelete.next;
	 
	        nodeToDelete = null;
	 
	        return head;
	}

	public void display() {
		Node current = head;
		if(head==null) {
			System.out.println("List is empty");  
			return;  
		}
		System.out.println("Nodes of doubly linked list: ");  
		while(current != null) {  
			//Prints each node by incrementing the pointer.  

			System.out.print(current.data + " ");  
			current = current.next;  
		}
		System.out.println();
	}


	public static void main(String[] args) {  

		DoublyLinkedList doublyLinkedList = new DoublyLinkedList();  
		doublyLinkedList.add(1);
		doublyLinkedList.add(2);
		doublyLinkedList.add(3);
		doublyLinkedList.add(4);
		doublyLinkedList.display();
		
		System.out.println("Element found :"+doublyLinkedList.contains(3));
		System.out.println("Element found :"+doublyLinkedList.contains(7));
		doublyLinkedList.remove(3);
		System.out.println("DoublyLikedList after deleting element 3");
		doublyLinkedList.display();  
	}  
}
