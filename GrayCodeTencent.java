package codingforjob;

import java.util.Scanner;

/*
在一组数的编码中，若任意两个相邻的代码只有一位二进制数不同， 则称这种编码为格雷码(Gray Code)，请编写一个函数，使用递归的方法生成N位的格雷码。
给定一个整数n，请返回n位的格雷码，顺序为从0开始。
测试样例：
1
返回：["0","1"]
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
	 * 递归实现
	 * 思路：由于除了最高位（左边第一位），格雷码的位元完全上下对称，可以根据n-1的格雷码，求n位的格雷码
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
	 * 非递归实现
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
	 * 非递归实现
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
