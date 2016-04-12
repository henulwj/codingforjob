package codingforjob.leetcode;

/*
 Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */

/***
 * ˼·��
 * int������32λ����������������һ��32λ����洢����Ԫ�ض�Ӧ������λ��1���ֵĴ���������ٽ������ÿһ��Ԫ��ģ���������µ�Ԫ��Ϊ0��1
 * �����Ӧʮ������Ϊ�Ǹ���
 * 
һ����������һ��Ԫ��ֻ����1�Σ���������Ԫ�ض�����k�Σ������ֻ����1�ε�Ԫ��
[����˼·]
��kΪż��ʱ���������
��kΪ����ʱ����������ÿ��Ԫ�ص�ÿһ��������λ���mod k���õ������λ����1�ε�Ԫ�أ�ʱ�临�Ӷ�O(nlen)���ռ临�Ӷ�ΪO(1)
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
