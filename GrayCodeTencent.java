package codingforjob;

import java.util.Scanner;

/*
��һ�����ı����У��������������ڵĴ���ֻ��һλ����������ͬ�� ������ֱ���Ϊ������(Gray Code)�����дһ��������ʹ�õݹ�ķ�������Nλ�ĸ����롣
����һ������n���뷵��nλ�ĸ����룬˳��Ϊ��0��ʼ��
����������
1
���أ�["0","1"]
 */


/***
 * 
 * @author lwj
 *
 */


public class GrayCodeTencent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		while(cin.hasNext()){
			int n = cin.nextInt();
			
			if(n>0){
				String[] str = getGray2(n);
				for (int i = 0; i < str.length; i++) {
					System.out.println(str[i]);
				}
			}else{
				return;
			}
		}
	}
	
	/***
	 * �ݹ�ʵ��
	 * ˼·�����ڳ������λ����ߵ�һλ�����������λԪ��ȫ���¶Գƣ����Ը���n-1�ĸ����룬��nλ�ĸ�����
	 * @param n
	 * @return
	 */
	public static String[] getGray(int n){
		String[] graystr = new String[(int)Math.pow(2, n)];
		if(n==1){
			graystr[0] = "0";
			graystr[1] = "0";
			return graystr;
		}
		String[] before = getGray(n-1);
		for(int i=0; i<before.length; i++){
			graystr[i] = "0" + before[i];
			graystr[graystr.length-1-i] = "1" + before[i];
		}
		return graystr;
	}
	
	/***
	 * �ǵݹ�ʵ��
	 * @param n
	 * @return
	 */
	public static String[] getGray2(int n){
		String[] graystr = new String[(int)Math.pow(2, n)];
		for(int i = 0; i < (int)Math.pow(2, n); i++){
//			System.out.println(Integer.toBinaryString(i^(i>>1)));
			StringBuilder strbuild = new StringBuilder(Integer.toBinaryString(i^(i>>1)));
			int len = strbuild.length();
			for(int j = 0; j< n-len; j++){
				strbuild.insert(0, '0');
			}
			graystr[i] = strbuild.toString();
		}
		return graystr;
	}
	
	/***
	 * �ǵݹ�ʵ��
	 * @param n
	 * @return
	 */
	public static String[] getGray3(int n){
		String[] graystr = new String[(int)Math.pow(2, n)];
		for(int i = 0; i < (int)Math.pow(2, n); i++){
//			System.out.println(Integer.toBinaryString(i^(i>>1)));
			StringBuilder strbuild = new StringBuilder(Integer.toBinaryString(i^(i>>1)));
			int len = strbuild.length();
			for(int j = 0; j< n-len; j++){
				strbuild.insert(0, '0');
			}
			graystr[i] = strbuild.toString();
		}
		return graystr;
	}

}
