package codingforjob.leetcode;

/*
 Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */

/***
 * 思路：
 * int变量有32位二进制数，可以用一个32位数组存储所有元素对应二进制位上1出现的次数，最后再将数组的每一个元素模三，则留下的元素为0或1
 * 则其对应十进制数为那个数
 * 
一个数组中有一个元素只出现1次，其他所有元素都出现k次，求这个只出现1次的元素
[解题思路]
当k为偶数时，进行异或
当k为奇数时，将数组中每个元素的每一个二进制位相加mod k，得到结果即位出现1次的元素，时间复杂度O(nlen)，空间复杂度为O(1)
 * @author lwj
 *
 */


public class LeetCode137SingleNumber2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,1,3,1,2,3,-1,2,3};
		int res = getSingleNumber2(arr);
		System.out.println(res);
	}
	
	
	public static int getSingleNumber2(int[] arr){
		int res = 0;
		int[] bitsum = new int[32];
		for (int i = 0; i < bitsum.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				bitsum[i] += (arr[j]>>i)&1;
			}
			res |= (bitsum[i]%3)<<i;
		}
		return res;
		
	}
	
	

}
