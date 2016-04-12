package codingforjob.leetcode;

import java.util.Stack;

/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 */

/***
 * 思路：
 波兰表达式：从左至右读入表达式，如果一个操作符后面跟着两个操作数时，则计算，然后将结果作为操作数替换这个操作符和两个操作数，重复此步骤，直至所有操作符处理完毕。比如2 + 3 * (5 - 1)这个表达式的波兰表达式为+ 2 * 3 - 5 1来表示。
 逆波兰表达式：从左往右依次读取，当读到操作符时，将之前的两个操作数做计算，然后替换这两个操作数和操作符，接着读取，重复此步骤。比如2 + 3 * (5 - 1)用逆波兰式来表示则是：2 3 5 1 - * +。
 
 对于此题的逆波兰表达式，可以采用栈来实现
 将读取到的数据入栈，当读取到一个字符时，出栈两个数进行运算，运算结果继续入栈，直到运算完毕，栈中只有一个数据，就是所求的结果。
 * 
 * @author lwj
 *
 */

public class LeetCode150EvaluteReversePolishNotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] tokens = {"2", "1", "+", "3", "*"};
		System.out.println(evalRPN(tokens));
		
	}
	
	
	public static int evalRPN(String[] tokens){
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < tokens.length; i++) {
			if(isOperator(tokens[i])){
				int b = stack.pop();
				int a = stack.pop();
				stack.push(operateNum(a, b, tokens[i]));
			}
			else{
				stack.push(Integer.valueOf(tokens[i]));
			}
		}
		int res = stack.pop();
		return res;
	}
	
	private static boolean isOperator(String str){
		if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"))   
            return true;  
        return false; 
	}
	
	private static int operateNum(int a, int b, String operator){
		
		int res = 0;
		switch (operator) {
			case "+":
				res = a+b;
				break;
			case "-":
				res = a-b;
				break;
			case "*":
				res = a*b;
				break;
			case "/":
				res = a/b;
				break;
			default:
				break;
		}
		return res;
	}

}
