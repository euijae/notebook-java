package datastructures.stack;

import java.util.Stack;

public class Calculator {

	public static void main(String[] args) {
		int ans = calculator("5*(9*2+2+2+2+2+(4+3*2+1)/3)"); //1+((2+3)*4+5)*6
		System.out.println(ans);
	}

	public static int calculator(String str) {
		Stack<Integer> operands = new Stack<>();
		Stack<Character> operators = new Stack<>();
		int i = 0;
		
		while(i < str.length()) {
			char ch = str.charAt(i++);
			
			if(Character.isDigit(ch)) {
				operands.push(Character.getNumericValue(ch));
				handleMultDiv(operands, operators);
			} else if(isOperator(ch)) {
				if(ch == ')') {
					handleParentheses(operands, operators);
				} else {
					operators.push(ch);
				}
			}
		}
		
		infix(operands, operators);
		
		return operands.pop();
	}

	private static void handleMultDiv(Stack<Integer> operands, Stack<Character> operators) {
		if(!operators.isEmpty()) {
			if(operators.peek() == '*' || operators.peek() == '/') {
				char temp = operators.pop();
				int op1 = operands.pop();
				int op2 = operands.pop();
				operands.push((temp == '*') ? op1*op2 : op2/op1);
			}
		}
	}
	
	private static void infix(Stack<Integer> operands, Stack<Character> operators) {
		while(!operators.isEmpty()) {
			char ch = operators.pop();
			int op1 = operands.pop();
			int op2 = operands.pop();
			
			if(ch == '+') {
				operands.push(op1 + op2);
			} else if(ch == '-'){
				operands.push(op2 - op1);
			} else if(ch == '*') {
				operands.push(op2 * op1);
			} else if(ch == '/') {
				operands.push(op2 / op1);
			}
		}
	}
	
	private static void handleParentheses(Stack<Integer> operands, Stack<Character> operators) {
		while(!operators.isEmpty() && !operands.isEmpty() && operators.peek() != '(') {
			char ch = operators.pop();
			int op1 = operands.pop();
			int op2 = operands.pop();
			
			if(ch == '+') {
				operands.push(op1 + op2);
			} else if(ch == '-') {
				operands.push(op2 - op1);
			} else if(ch == '*') {
				operands.push(op1 * op2);
			} else if(ch == '/') {
				operands.push(op2 / op1);
			} else {
				throw new RuntimeException("incorrrect...");
			}
		}
		
		if(operators.peek() == '(')
			operators.pop();
		else {
			throw new RuntimeException("incorrrect...");
		}
	}
	
	private static boolean isOperator(char ch) {
		char [] arr = {'+', '-', '*', '/', '(', ')'};
		for(int i = 0; i < arr.length; i++)
			if(arr[i] == ch)
				return true;
		return false;
	}
}
