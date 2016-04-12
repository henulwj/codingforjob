package codingforjob.leetcode;

import java.util.Arrays;

/*
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity? 
 */

/***
 * ˼·���������ʱ�临�Ӷȳ���
 * ������е��Ѷȣ����忴����
����һ�飬�������������XOR �����������Ϊ diff ������2�ε�������ͨ�������ȥ�����µ���2������ηֳ���
�����һ���������⣬�ҵ�����Ĳ�ͬ���������ֳܷ���
diff ��ʵ����������������������ٱ任 diff ��ʹ�� diff �ӵ�λ����λ�ĵ�һ��1���£�����λ���϶���0������ a^diff != b^diff һ���������ͷֿ�����������
������a �� 3��b ��5

3�Ķ����ƣ�011
5�Ķ����ƣ�101
3^5 = 6 �� ������Ϊ110
�������110�Ĳ��룬Ϊ010��Ȼ��110 & 010 = 010
�����ͽ�diff����˽���1��1������λ�ö�Ϊ0���������Ǹ�1����a��b��һ������ͬ��λ�ã������������ֿ�a��b�ˡ� 

�����Ǹ�û�����������棺

���ȼ���nums�������������ֵ���򣬼�Ϊxor

��lowbit = xor & -xor��lowbit�ĺ���Ϊxor�ӵ�λ���λ����һ����0λ����Ӧ������

�������xor = 6�������ƣ�0110������-xorΪ�������ƣ�1010��-6�Ĳ��룬two's complement��

��lowbit = 2�������ƣ�0010��

���������������ʣ���ͬ0��1��

��ֻ����һ�ε��������ֱַ�Ϊa��b

��֪a & lowbit��b & lowbit�Ľ��һ����ͬ

ͨ�����ַ�ʽ�����ɽ�a��b��ֿ���

�ܵ���˵��
����������Ԫ�ض��������õ�һ����Ϊ0�Ľ���������������еĲ�Ϊ0��ĳһλ������ֳ�����

�������е�Ԫ�ؽ������������������ֵ����õ������

 * @author lwj
 *
 */


public class LeetCode260SingleNumber3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,3,2,0};
		int[] ans = getSingleNumber3(arr);
		System.out.println(Arrays.toString(ans));
	}
	
	
	public static int[] getSingleNumber3(int[] arr){
		int[] ans = new int[2];
        int diff = 0;
        for (int i = 0; i < arr.length; i++) {
			diff ^= arr[i]; 
		}
        diff &= -diff;
        for (int i = 0; i < arr.length; i++) {
        	if((arr[i] & diff) == 0) {
                ans[0] ^= arr[i];
            }else {
                ans[1] ^= arr[i];
            }
		}
        return ans;
	}

}
