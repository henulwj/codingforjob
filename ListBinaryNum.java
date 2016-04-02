package codingforjob;

import java.util.Scanner;

/*
ʱ�ޣ�100ms �ڴ����ƣ�10000K  ��ʱ�ޣ�300ms
������ ����һ��С��20��������n��Ҫ�󰴴�С�����˳��������е�nλ����������ÿ����ռһ�С�
���룺 ����һ��С��20��������n��
����� ����С�����˳��������е�nλ����������ÿ����ռһ�С�
���������� 3
���������
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
	 * ��ʮ������ת��������������2ȡ��
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
	 * �û��ݷ�
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
