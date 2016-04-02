package codingforjob;

import java.util.Scanner;

/*
时限：100ms 内存限制：10000K  总时限：300ms
描述： 输入一个小于20的正整数n，要求按从小到大的顺序输出所有的n位二进制数，每个数占一行。
输入： 输入一个小于20的正整数n。
输出： 按从小到大的顺序输出所有的n位二进制数，每个数占一行。
输入样例： 3
输出样例：
000
001
010
011
100
101
110
111
 */



public class ListBinaryNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		if(cin.hasNext()){
			int n = cin.nextInt();
			int[] arr = new int[20];
			long t1 = System.currentTimeMillis();
			commonSwith(n, arr);
//			searchSwitch(n, 0, arr);
			long t2 = System.currentTimeMillis();
			System.out.println(t2-t1);
		}
	}
	
	/***
	 * 将十进制数转二进制数，除以2取余
	 * @author lwj
	 *
	 */
	public static void commonSwith(int n, int[] arr) {
		int tmp;
		if(n>0&&n<20){
			for(int i = 0; i< (int)Math.pow(2, n); i++){
				tmp = i;
				for(int j = n-1; j >= 0; j--){
					arr[j] = tmp%2;
					tmp /=2;
				}
				for(int k = 0; k < n; k++){
					System.out.print(arr[k]);
				}
				System.out.println();
			}
		}
		else{
			return;
		}
	}
	
	/***
	 * 用回溯法
	 * @param n
	 * @param m
	 * @param arr
	 */
	public static void searchSwitch(int n, int m, int[] arr){
		if(n>0&&n<20){
			if(n==m){
				for (int i = 0; i < n; i++) {
					System.out.print(arr[i]);
				}
				System.out.println();
			}else{
				arr[m] = 0;
				searchSwitch(n, m+1, arr);
				arr[m] = 1;
				searchSwitch(n, m+1, arr);
			}
		}else{
			return;
		}
	}
	
	

}
