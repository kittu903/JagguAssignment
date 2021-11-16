package com.DataStructure;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
	List<T> list = new ArrayList<T>();

	@Override
	public String toString() {
		return "Stack [list=" + list + "]";
	}

	//that returns the Object at the top most element of the stack without deleting that element from the stack
	public T peek() {
		if (list.isEmpty()) {
			return null;
		}
		return list.get(list.size() - 1);
	}

	//Removes the Object presents at the top
	public T pop() {
		if (list.isEmpty()) {
			return null;
		}
		T top = list.get(list.size() - 1);
		list.remove(list.size() - 1);
		return top;
	}

	//Add Object to the top 
	public void push(T t) {
		list.add(t);
	}

	public boolean empty() {
		return list.isEmpty();
	}
}
