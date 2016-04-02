package codingforjob;
/*
��ֵ��Ϸ
Time Limit: 2000/1000 MS (Java/Others) Memory Limit: 65536/65536 K (Java/Others)
Problem Description:
Ϊ������Ե���ѧ������СB��СA������һ���������ֵ��Ϸ����һ������������һ�����淨��ÿ�˴�ָ������ֵ��Χ�и���ѡ��һ����������СAѡ�����ֵΪa��СBѡ�����ֵΪb��������һ�����ȷֲ���������������ڸ���ֵ��Χ���������һ������c��������ʤ����Ϸ����Ϊ˭ѡ������c����˭ȡ��ʤ��������СB��Ů�����ر��嵱���˵�����c֮��Ĳ�ֵ���ʱ��СB��ʤ��

������ǰ����Ϸ�У�СAΪ������ʿ����������Ӯ�٣�������ر��������ܹ���СB�Ƚ���̵�ӳ�����������������������Ѿ�֪����СB��ѡ����ֵ��ָ������ֵ��Χ��СAϣ�������ѡ��һ����ֵʹ������ʤ�ĸ������
����
�����������У�ÿ��Ϊһ�����ݣ���������������n��b���ֱ��ʾ��ֵ��Χ��СB�������������1<=b<=n<=10^9
���
��ÿ�����룬�ڵ������������һ������ΪСA��ѡ������ʹ��СA��ʤ�ĸ�����������ڶ�������������������С���Ǹ�

��������
3 1
4 3
�������
2
2
*/

/***
 * 
 * @author lwj
 *
 */

import java.util.Scanner;

public class NumberGame360 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int b = in.nextInt();
            int a = 0;
            if (b <= n / 2) {
                a = b + 1;
            } else {
                a = b - 1;
            }
            System.out.println(a);
        }
    }
}


// �����ñ����ⷨ�������ġ�����TLE�ˡ�
//import java.util.Scanner;
///**
// * ˼·�����ñ���ɨ��ķ�ʽ��ͷ��β������1-n��Щ�����ֵ�ʱ��A,B��������Ӯ�ĸ��ʷֱ��Ƕ��١�
// * ע�⣺
// * 1,��ֵ���ʱ��BӮ��������23�У�
// * 2����Ϊ��Ŀ�Ѿ���֪BӮ�Ķ��ˣ���������ֻҪA��һ����BӮ�ĸ���һ����ģ��˿�����Ӯ�ĸ���Ҳ�Ƚϴ󡣣�����29�У�
// */
//public class NumberGame360 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()) {
//            int n = in.nextInt();
//            int b = in.nextInt();
//            int numB = 0;
//            int numA = 0;
//            for (int i = 1; i <= n; i++) {
//                numA = 0;
//                numB = 0;
//                int a = i;
//                for (int j = 1; j <= n; j++) {
//                    if ((int)Math.abs(a - j) < (int)Math.abs(b - j)) {
//                        numA++;
//                    } else {
//                        numB++;
//                    }
//                }
//                if (numA >= numB) {
//                    System.out.println(i);
//                    break;
//                }
//            }
//        }
//    }
//}