package codingforjob;

/*
字符置换
Time Limit: 6000/2000 MS (Java/Others) Memory Limit: 65536/65536 K (Java/Others)
Problem Description:
小B最近迷上了字符串处理技术，他设计了各种处理方式，并计算字符串的属性。这次也不例外，他定义了一种新的字符置换方式。小B研究的字符串由ASCII码字母和“.”构成，这次的研究对象是“.”。他关心的对象是字符串中出现的连续两个“.”。若每次操作把其中最开始的连续两个“.”以一个“.”替代，则可以将函数f(s) 定义为使得串中不出现连续两个“.”的最小置换次数。
现考虑m个字符替换操作，每次将指定位置的字符替换为给定的字符，求替换后函数f(s)的值。
输入
输入有若干组，每组的第一行为两个整数n和m，1<= n,m<=300000，表示字符串的长度和字符替换操作的次数。第二行为所给的字符串，随后紧跟m行操作，每行由一个正整数x和一个字母c构成，表示将字符串中位置m处的字符置换为字母c。
输出
对每组输入的每个置换操作，在单独的行中输出函数f(s)的结果

样例输入
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
样例输出
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
 * 思路：根据输入每走一步都进行字符串的修改，利用字符数组来进行记录。
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

