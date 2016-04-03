package codingforjob;

import java.util.Scanner;

/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
 */

/***
 * ˼·������ʱleetcode 64�⣬�������ά���飬�����Ͻǵ����½ǵ����·����
 * 1���������ö�ٵĻ������m,n�Ƚϴ�ʱ��������
 * 2�����ö�̬�滮 dp[i][j] = min{dp[i-1][j]+dp[i][j-1]}+a[i][j]
 * a��dp[0][0] = a[0][0]
 * b��dp[0][j>0] = dp[0][j-1] + a[0][j]
 * c��dp[i>0][0] = dp[i-1][0] + a[i][0]
 * d��dp[i>0][j>0] = min{dp[i-1][j]+dp[i][j-1]}+a[i][j]
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
	 * �ҵ���С·��ֵ��������
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
	 * �Ż��ռ䣬ֻʹ��һά���洢,�ռ临�Ӷ�Ϊ O(n)
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
