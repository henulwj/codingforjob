package codingforjob;

import java.util.Scanner;

/*
 * ��������һ�������ֵĴ���������һ�㣬�ҳ������
 */

public class FindOverHalfNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		while(cin.hasNext()){
			int n = cin.nextInt();
			if(n>0){
				int[] arr = new int[n];
				for (int i = 0; i < arr.length; i++) {
					arr[i] = cin.nextInt();
				}
				System.out.println(findOverHalfNumber(arr, n));
			}
			else{
				return;
			}
		}
		
	}
	
	/***
	 * ˼·����������ʱ��������ֵ��һ����index���������������һ����time,��index���ֵĴ�������ʼֵΪ1
	 * 1��time����0ʱ������ǰ��������ֵ��index
	 * 2��time������0ʱ����������һ������index��ͬ����time��1
	 * 3��time������0ʱ����������һ������index����ͬ����time��1
	 * @param arr
	 * @param n
	 * @return
	 */
	public static int findOverHalfNumber(int[] arr, int n){
		int index = arr[0];
		int time = 1;
		for(int i = 1; i<n; i++){
			if(time == 0){
				index = arr[i];
				time = 1;
			}
			else{
				if(arr[i] == index){
					time++;
				}
				else{
					time--;
				}
			}
		}
		return index;
	}

}
