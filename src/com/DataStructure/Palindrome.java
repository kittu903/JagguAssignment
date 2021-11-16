package com.DataStructure;

import java.util.Scanner;

public class Palindrome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String to check if it is palindrome or Not");
		String text = sc.next();
		char[] charArray = text.toLowerCase().toCharArray();
		int start = 0;
		int end = charArray.length-1;
		boolean isPalindrom = true;
		while(start<end) {
			if(charArray[start]!=charArray[end]) {
				isPalindrom=false;
				break;
			}
			start++;
			end--;
		}
		if(isPalindrom)
			System.out.println(text+" is palindrom");
		else System.out.println(text+" is not a palindrom");
		sc.close();
	}
}
