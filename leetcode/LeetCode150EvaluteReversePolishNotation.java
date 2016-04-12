package codingforjob.leetcode;

import java.util.Stack;

/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 */

/***
 * ˼·��
 �������ʽ���������Ҷ�����ʽ�����һ�������������������������ʱ������㣬Ȼ�󽫽����Ϊ�������滻������������������������ظ��˲��裬ֱ�����в�����������ϡ�����2 + 3 * (5 - 1)������ʽ�Ĳ������ʽΪ+ 2 * 3 - 5 1����ʾ��
 �沨�����ʽ�������������ζ�ȡ��������������ʱ����֮ǰ�����������������㣬Ȼ���滻�������������Ͳ����������Ŷ�ȡ���ظ��˲��衣����2 + 3 * (5 - 1)���沨��ʽ����ʾ���ǣ�2 3 5 1 - * +��
 
 ���ڴ�����沨�����ʽ�����Բ���ջ��ʵ��
 ����ȡ����������ջ������ȡ��һ���ַ�ʱ����ջ�������������㣬������������ջ��ֱ��������ϣ�ջ��ֻ��һ�����ݣ���������Ľ����
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
