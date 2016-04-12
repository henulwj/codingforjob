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
 * 思路：暴力求解时间复杂度超了
 * 这道题有点难度，具体看下面
遍历一遍，将所有数字异或XOR 起来，结果设为 diff ，出现2次的数可以通过异或消去，留下的那2个数如何分出？
这就像一个分类问题，找到两类的不同特征，就能分出。
diff 其实就是那两个数的异或结果，再变换 diff ，使得 diff 从低位到高位的第一个1留下，其它位置上都置0。这样 a^diff != b^diff 一定成立，就分开了两个数。
举例：a ＝ 3，b ＝5

3的二进制：011
5的二进制：101
3^5 = 6 ＝ 二进制为110
求二进制110的补码，为010，然后110 & 010 = 010
这样就将diff变成了仅有1个1，其它位置都为0的数，且那个1就是a和b第一个不相同的位置，这样就能区分开a和b了。 

上面那个没看懂，看下面：

首先计算nums数组中所有数字的异或，记为xor

令lowbit = xor & -xor，lowbit的含义为xor从低位向高位，第一个非0位所对应的数字

例如假设xor = 6（二进制：0110），则-xor为（二进制：1010，-6的补码，two's complement）

则lowbit = 2（二进制：0010）

根据异或运算的性质，“同0异1”

记只出现一次的两个数字分别为a与b

可知a & lowbit与b & lowbit的结果一定不同

通过这种方式，即可将a与b拆分开来

总的来说：
将数组所有元素都进行异或得到一个不为0的结果，根据这个结果中的不为0的某一位将数组分成两组

将两组中的元素进行异或，两个数组的异或值，则得到最后结果

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
