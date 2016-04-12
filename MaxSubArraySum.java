package codingforjob;

import java.util.Scanner;

/*
 * �����������飬��һ���ǿյ����������飬ʹ�����ĺ���� leetcode 53
 */


/***

˼·1 ����ö�٣����i��0..n �C 1���յ�j = i��n �C 1�����i..j�� ʱ�临�Ӷ�O(n3)

˼·2 ��������ö�٣� ���0..n �C 1, �յ�j = i..n �C 1����˳�㡱��ͣ�ʱ�临�Ӷ�O(n2)

˼·3 ����
�֣� ���������ȳ��������飬�ֱ���� T(n / 2)
�ϣ� ��Խ���ĵ�����������ϣ�ö�٣�O(n)
ʱ�临�Ӷ� O(nlogn)

˼·4 dp
dp[i]��ʾ��a[i]��β�����������ĺ�
dp[i] = max(dp[i �C 1] + a[i], a[i])
����a[i �C 1]��dp[i �C 1] + a[i]
������a[i �C 1]: a[i]
��ֵ dp[0] = a[0]
�𰸣�����dp[0..n �C 1]
ʱ�临�Ӷ� O(n), �ռ临�Ӷ�O(n)
�ռ��Ż�: dp[i]Ҫ��ô��
endHere = max(endHere + a[i], a[i])
���answer = max(endHere, answer)

˼·5 ����һ������ö��
����
sum[i] = a[0] + a[1] + a[2] +��+ a[i]   i>=0
sum[-1] = 0
�� �� 0 <= i <= j 
a[i] + a[i + 1] + �� + a[j] = sum[j] �C sum[i �C 1]
���Ǿ���Ҫ������һ�����ֵ
��j���ǿ�����õ�ǰ��sum[j]��ȡ��i �C 1һ����֮ǰ��С��sumֵ����һ��������¼sum����Сֵ
ʱ��O(n),�ռ�O(1)



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
	 * ˼·3 �����㷨
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
	 * ˼·3 ��̬�滮
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
