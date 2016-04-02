package codingforjob;
/*
数值游戏
Time Limit: 2000/1000 MS (Java/Others) Memory Limit: 65536/65536 K (Java/Others)
Problem Description:
为考验各自的数学能力，小B和小A经常在一起玩各种数值游戏，这一次他们又有了一种新玩法。每人从指定的数值范围中各自选择一个整数，记小A选择的数值为a，小B选择的数值为b。他们用一个均匀分布的随机数发生器在该数值范围中随机生成一个整数c，定义制胜的游戏规则为谁选的数离c近则谁取得胜利。由于小B是女生，特别定义当两人的数与c之间的差值相等时，小B获胜。

由于先前的游戏中，小A为表现绅士风度总是输多赢少，因此他特别渴望这次能够给小B比较深刻的映像，所以向你求助。你事先已经知道了小B所选的数值和指定的数值范围，小A希望你帮他选择一个数值使得他获胜的概率最大。
输入
输入有若干行，每行为一组数据，包含两个正整数n和b，分别表示数值范围和小B所需的数，其中1<=b<=n<=10^9
输出
对每组输入，在单独的行中输出一个数，为小A所选的数，使得小A获胜的概率最大。若存在多个这样的数，则输出最小的那个

样例输入
3 1
4 3
样例输出
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


// 附上用暴力解法做出来的。但是TLE了。
//import java.util.Scanner;
///**
// * 思路：利用暴力扫描的方式从头到尾，计算1-n这些数出现的时候，A,B所猜数字赢的概率分别是多少。
// * 注意：
// * 1,差值相等时候B赢。（代码23行）
// * 2，因为题目已经告知B赢的多了，所以现在只要A猜一个和B赢的概率一样多的，此刻下他赢的概率也比较大。（代码29行）
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