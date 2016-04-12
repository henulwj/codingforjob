package codingforjob.leetcode;

/*
Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */

/***
 * 思路：
 * 1.暴力循环，时间复杂度O(n^2)
 * 2、采用异或运算，a^a = 0,所有的数据异或后得到就是单个元素,时间复杂度O(n)
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
