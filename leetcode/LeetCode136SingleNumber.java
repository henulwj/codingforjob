package codingforjob.leetcode;

/*
Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */

/***
 * ˼·��
 * 1.����ѭ����ʱ�临�Ӷ�O(n^2)
 * 2������������㣬a^a = 0,���е���������õ����ǵ���Ԫ��,ʱ�临�Ӷ�O(n)
 * @author lwj
 *
 */

public class LeetCode136SingleNumber {

	public static void main(String[] args){
		
		int[] arr = {1,2,3,0,2,1,3};
		int res = getSingleNumber(arr);
		System.out.println(res);
		
	}
	
	public static int getSingleNumber(int[] arr){
		int res = 0;
		for (int i = 0; i < arr.length; i++) {
			res ^= arr[i];
		}
		return res;
	}
}
