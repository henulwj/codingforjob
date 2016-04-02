package codingforjob;

/*
�ַ��û�
Time Limit: 6000/2000 MS (Java/Others) Memory Limit: 65536/65536 K (Java/Others)
Problem Description:
СB����������ַ�����������������˸��ִ���ʽ���������ַ��������ԡ����Ҳ�����⣬��������һ���µ��ַ��û���ʽ��СB�о����ַ�����ASCII����ĸ�͡�.�����ɣ���ε��о������ǡ�.���������ĵĶ������ַ����г��ֵ�����������.������ÿ�β����������ʼ������������.����һ����.�����������Խ�����f(s) ����Ϊʹ�ô��в���������������.������С�û�������
�ֿ���m���ַ��滻������ÿ�ν�ָ��λ�õ��ַ��滻Ϊ�������ַ������滻����f(s)��ֵ��
����
�����������飬ÿ��ĵ�һ��Ϊ��������n��m��1<= n,m<=300000����ʾ�ַ����ĳ��Ⱥ��ַ��滻�����Ĵ������ڶ���Ϊ�������ַ�����������m�в�����ÿ����һ��������x��һ����ĸc���ɣ���ʾ���ַ�����λ��m�����ַ��û�Ϊ��ĸc��
���
��ÿ�������ÿ���û��������ڵ����������������f(s)�Ľ��

��������
10 3
.b..bz....
1 h
3 c
9 f
4 4
.cc.
2 .
3 .
2 a
1 a
�������
4
3
1
1
3
1
1
 */

import java.util.Scanner;
/**
 * @author 
 * ˼·����������ÿ��һ���������ַ������޸ģ������ַ����������м�¼��
 */
public class CharReplace360 {
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            char[] c = new char[n];
            String str = in.next();
            for (int i = 0; i < n; i++) {
                c[i] = str.charAt(i);
            }
            for (int i = 0; i < m; i++) {
                int index = in.nextInt();
                str = in.next();
                char c1 = str.charAt(0);
                c[index - 1] = c1;
                System.out.println(fun(c));
            }
        }
    }
    public static int fun (char[] c) {
        int result = 0;
        for (int i = 0; i < c.length - 1; i++) {
            if(c[i] == '.' &&  c[i + 1] == '.') {
                result++;
            }
        }
        return result;
    }
}

