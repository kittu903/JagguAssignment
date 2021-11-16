package com.customListImplementation;

import java.io.FileInputStream;
import java.util.Scanner;

public class LinkedList<T> {

	Node<T> head; // head of list

	// Linked list Node.
	// Node is a static nested class
	// so main() can access it
	static class Node<T> {

		T data;
		Node<T> next;

		// Constructor
		Node(T data)
		{
			this.data = data;
			next = null;
		}
	}

	public LinkedList<T> add(T data){
		// Create a new node with given data
		Node<T> new_node = new Node<T>(data);
		new_node.next = null;

		// If the Linked List is empty,
		// then make the new node as head
		if (this.head == null) {
			this.head = new_node;
		}
		else {
			// Else traverse till the last node
			// and insert the new_node there
			Node<T> last = this.head;
			while (last.next != null) {
				last = last.next;
			}

			// Insert the new_node at last node
			last.next = new_node;
		}

		// Return the list by head
		return this;
	}
	
	public void printList(){
		Node<T> currNode = this.head;

		System.out.println("\nLinkedList: ");

		// Traverse through the LinkedList
		while (currNode != null) {
			System.out.println(currNode.data + " ");
			currNode = currNode.next;
		}
		System.out.println("\n");
	}

	// Method to delete a node in the LinkedList by POSITION
	public LinkedList<T> remove(T t){
		// Store head node
		Node<T> currNode = this.head, prev = null;

		if (currNode != null && currNode.data.equals(t)) {
			this.head = currNode.next;
			System.out.println(t + " found and deleted");
			return this;
		}
		while (currNode != null && !currNode.data.equals(t)) {
			prev = currNode;
			currNode = currNode.next;
		}

		if (currNode != null) {
			prev.next = currNode.next;

			System.out.println(t + " found and deleted");
		}

		// If key was not present in linked list
		// currNode should be null
		if (currNode == null) {
			System.out.println(t + " not found");
		}
		return this;
	}

	public Boolean contains(T t) {
		// Store head node
		Node<T> currNode = this.head;

		if (currNode != null && currNode.data.equals(t)) {
			return Boolean.TRUE;
		}

		// Search for the key to be deleted,
		// keep track of the previous node
		// as it is needed to change currNode.next
		while (currNode != null && !currNode.data.equals(t)) {
			currNode = currNode.next;
		}

		// If the key was present, it should be at currNode
		// Therefore the currNode shall not be null
		if (currNode != null) {
			return Boolean.TRUE;
		}else {
			return Boolean.FALSE;
		}

	}
}
