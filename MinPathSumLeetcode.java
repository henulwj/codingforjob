package codingforjob;

import java.util.Scanner;

/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
 */

/***
 * 思路：本题时leetcode 64题，求给定二维数组，从左上角到右下角的最短路径：
 * 1、如果采用枚举的话，如果m,n比较大时，不可行
 * 2、采用动态规划 dp[i][j] = min{dp[i-1][j]+dp[i][j-1]}+a[i][j]
 * a、dp[0][0] = a[0][0]
 * b、dp[0][j>0] = dp[0][j-1] + a[0][j]
 * c、dp[i>0][0] = dp[i-1][0] + a[i][0]
 * d、dp[i>0][j>0] = min{dp[i-1][j]+dp[i][j-1]}+a[i][j]
 * @author lwj
 *
 */


public class MinPathSumLeetcode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		while(cin.hasNext()){
			int m = cin.nextInt();
			int n = cin.nextInt();
			if(m>0 && n>0){
				int[][] arr = new int[m][n];
				for (int i = 0; i < m; i++) {	
					for (int j = 0; j < n; j++) {
						arr[i][j] = cin.nextInt();
					}
				}
				System.out.println(findMinPathSum2(arr));
			}			
		}
		
	}
	
	/***
	 * 找到最小路径值，并返回
	 * @param arr
	 */
	public static int findMinPathSum(int[][] arr){
		int[][] dp = new int[arr.length][arr[0].length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if(i==0){
					if(j==0){
						dp[i][j] = arr[i][j];
					}
					else{
						dp[i][j] = dp[i][j-1] + arr[i][j];
					}
				}
				else if(j == 0){
					dp[i][j] = dp[i-1][j] + arr[i][j];
				}
				else{
					dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + arr[i][j];
				}
			}
		}
		return dp[arr.length-1][arr[0].length-1];
	}
	
	
	/***
	 * 优化空间，只使用一维来存储,空间复杂度为 O(n)
	 * @param arr
	 */
	public static int findMinPathSum2(int[][] arr){
		int[] dp = new int[arr[0].length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if(i==0){
					if(j==0){
						dp[j] = arr[i][j];
					}
					else{
						dp[j] = dp[j-1] + arr[i][j];
					}
				}
				else if(j == 0){
					dp[j] = dp[j] + arr[i][j];
				}
				else{
					dp[j] = Math.min(dp[j], dp[j-1]) + arr[i][j];
				}
			}
		}
		return dp[arr[0].length-1];
	}

}
