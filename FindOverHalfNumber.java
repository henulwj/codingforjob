package codingforjob;

import java.util.Scanner;

/*
 * 数组中有一个数出现的次数超过了一般，找出这个数
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
	 * 思路：遍历数组时保存两个值，一个是index，保存遍历的数，一个是time,是index出现的次数，初始值为1
	 * 1、time等于0时，将当前遍历数赋值给index
	 * 2、time不等于0时，遍历的下一个数与index相同，则time加1
	 * 3、time不等于0时，遍历的下一个数与index不相同，则time减1
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
