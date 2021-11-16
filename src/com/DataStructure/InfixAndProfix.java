package com.DataStructure;

public class InfixAndProfix {
	
	//Checking if character is operator or not
	public static boolean isOperator(char op){
		if(op == '+' || op == '-' || op == '*' || op == '/')
			return true;
		return false;
	}

	/*  precedence to an operator */
	public static int precedence(char op){
		switch (op){
		case '+' :
			return 1;
		case '-' :
			return 1;
		case '/' :
			return 2;
		case '*' :
			return 2;
		default :
			return 4;
		}
	}

	/* This function tell if the op1 has lower precedence than op2 */
	public static boolean isHigherPrecedence(char op1, char op2){
		if(precedence (op1) > precedence(op2))
			return true;
		return false;
	}
	
	//Convert Infix to Postfix
	public static String convertInixToPostfix(String infix){
		Stack<Character> operatorStack = new Stack<Character>();
		StringBuilder postfixString = new StringBuilder();
		
		//"3+5*2-8/4"
		for(int i=0; i<infix.length();i++) {
			char infixChar = infix.charAt(i);
			
			//Checking if infixChar is operator or number
			if(isOperator(infixChar)) {
				if(operatorStack.empty()) operatorStack.push(infixChar);
				else {
					if(isHigherPrecedence(infixChar, operatorStack.peek())) {
						operatorStack.push(infixChar);
					}else {
						while(!operatorStack.empty()) postfixString.append(operatorStack.pop());
						operatorStack.push(infixChar);
					}
				}
			}else {
				postfixString.append(infixChar);
			}
		}
		//Appending all characters present in stack in protfixString
		while(!operatorStack.empty()) postfixString.append(operatorStack.pop());
		return postfixString.toString();
	}

	public static int evaluatingPostfixExpression(String postfixExpression) {
		Stack<Integer> operatorStack = new Stack<Integer>();
		for(int i =0; i<postfixExpression.length();i++) {
			char postfixChar = postfixExpression.charAt(i);
			if(isOperator(postfixChar)) {
				int postfixChar2 = operatorStack.pop();
				int postfixChar1 = operatorStack.pop();
				operatorStack.push(operation(postfixChar1, postfixChar2, postfixChar));
			}else operatorStack.push(Character.getNumericValue(postfixChar));
		}
		return operatorStack.pop();
	}
	
	public static int operation(int valuePosition1, int valuePosition2, char operator) {
		if(operator=='+') return valuePosition1+valuePosition2;
		else if(operator=='-') return valuePosition1-valuePosition2;
		else if(operator=='*') return valuePosition1*valuePosition2;
		else if(operator=='/') return valuePosition1/valuePosition2;
		else return 0;
	}
	
	
	public static void main(String[] args){
		String postfixExpression = convertInixToPostfix("1+3*8");
		System.out.println("postfix expression for : \"1+3*8\"");
		System.out.println(postfixExpression);
		System.out.println(evaluatingPostfixExpression(postfixExpression));
		
		System.out.println("postfix expression for : \"8-3-4*6+3\"");
		postfixExpression = convertInixToPostfix("8-3-4*6+3");
		System.out.println(postfixExpression);
		System.out.println(evaluatingPostfixExpression(postfixExpression));
		
		System.out.println("postfix expression for : \"8-2+8/4+6-1-6/2\"");
		postfixExpression = convertInixToPostfix("8-2+8/4+6-1-6/2");
		System.out.println(postfixExpression);
		System.out.println(evaluatingPostfixExpression(postfixExpression));
	}
}
