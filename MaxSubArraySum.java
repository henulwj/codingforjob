package codingforjob;

import java.util.Scanner;

/*
 * 给定整数数组，求一个非空的连续子数组，使得它的和最大 leetcode 53
 */


/***

思路1 暴力枚举，起点i＝0..n – 1，终点j = i…n – 1，求和i..j， 时间复杂度O(n3)

思路2 “聪明”枚举， 起点0..n – 1, 终点j = i..n – 1，“顺便”求和，时间复杂度O(n2)

思路3 分治
分： 两个基本等长的子数组，分别求解 T(n / 2)
合： 跨越中心点的最大子数组合（枚举）O(n)
时间复杂度 O(nlogn)

思路4 dp
dp[i]表示以a[i]结尾的最大子数组的和
dp[i] = max(dp[i – 1] + a[i], a[i])
包含a[i – 1]：dp[i – 1] + a[i]
不包含a[i – 1]: a[i]
初值 dp[0] = a[0]
答案：最大的dp[0..n – 1]
时间复杂度 O(n), 空间复杂度O(n)
空间优化: dp[i]要存么？
endHere = max(endHere + a[i], a[i])
结果answer = max(endHere, answer)

思路5 另外一种线性枚举
定义
sum[i] = a[0] + a[1] + a[2] +…+ a[i]   i>=0
sum[-1] = 0
则 对 0 <= i <= j 
a[i] + a[i + 1] + … + a[j] = sum[j] – sum[i – 1]
我们就是要求这样一个最大值
对j我们可以求得当前的sum[j]，取的i – 1一定是之前最小的sum值，用一个变量记录sum的最小值
时间O(n),空间O(1)



 * @author lwj
 *
 */

public class MaxSubArraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		while(cin.hasNext()){
			int n = cin.nextInt();
			if(n > 0){
				int[] arr = new int[n];
				for (int i = 0; i < n; i++) {
					arr[i] = cin.nextInt();
				}
				System.out.println(maxSubArray4(arr, arr.length));
			}
			else{
				return;
			}
		}
	}
	
	/***
	 * 思路3 分治算法
	 * @param arr
	 * @return
	 */
	public static int maxSubArray3(int[] arr, int left, int right){
		if(arr.length == 1){
			return arr[0];
		}
		int len = right-left+1;
		int mid = len >> 1;
		int answer = Math.max(maxSubArray3(arr, left, mid-1), maxSubArray3(arr, mid, right));
		int now = arr[mid-1], may = now;
		for (int i = mid-2; i >= 0; i++) {
			may = Math.max(may, now+=arr[i]);
		}
		now = may;
		for (int i = mid; i <len ; ++i) {
			may = Math.max(may, now+=arr[i]);
		}
		return Math.max(answer, may);
	}
	
	
	/***
	 * 思路3 动态规划
	 * @param arr
	 * @return
	 */
	public static int maxSubArray4(int[] arr, int n){
//		int[] dp = new int[n];
//		dp[0] = arr[0];
		int tmp = arr[0];
		int answer = tmp;
		for (int i = 1; i < n; i++) {
			tmp = Math.max(tmp+arr[i], arr[i]);
			answer = Math.max(answer, tmp);
		}
		return answer;
	}

}
