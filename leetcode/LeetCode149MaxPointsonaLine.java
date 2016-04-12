package codingforjob.leetcode;

import java.util.HashMap;

/*
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 */

/***
 * 思路：
 * 1.两个循环，记录每一个点与剩余点的斜率，统计相同斜率点的数目
 * 2.注意坐标位置相同点
 * 3.注意垂直x轴的点
 * 4.注意同一个点不要再计算
 * 5.考虑到一个点被计算两次的情况 {[1,1],[0,0],[1,1]}
 * @author lwj
 *
 */


public class LeetCode149MaxPointsonaLine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point[] points = new Point[10];
//		points[0] = new Point(1,1);
//		points[1] = new Point(0,0);
//		points[2] = new Point(1,1);
		for (int i = 0; i < points.length; i++) {
			points[i] = new Point(1,1);
		}
		System.out.println(maxPoints(points));
	}
	
	public static int maxPoints(Point[] points){
		if(points.length == 0){
			return 0;
		}
		int maxnum = 0;
		for (int i = 0; i < points.length; i++) {
			HashMap<Double,Integer> slopenum = new HashMap<Double,Integer>();
			int curmaxnum = 1;
			int verticalnum = 0;
			int samenum = 0;
			for (int j = 0; j < points.length; j++) {
				//点数组中相同位置点
				if(j == i)
					continue;
				//相同点
				if(points[i].x == points[j].x && points[i].y == points[j].y){
					if(samenum == 0)
						samenum = 2;
					else
						samenum++;
				}
				//垂直的点
				else if(points[i].x == points[j].x){
					if(verticalnum == 0)
						verticalnum = 2;
					else
						verticalnum++;
					curmaxnum = Math.max(curmaxnum, verticalnum);
				}
				else{
					double k = (double)(points[i].y - points[j].y) / (points[i].x - points[j].x);
					if(!slopenum.containsKey(k)){
						slopenum.put(k, 2);
					}else{
						slopenum.put(k, slopenum.get(k)+1);
					}
					curmaxnum = Math.max(curmaxnum, slopenum.get(k));
				}
				//一个点被计算两次
				if(samenum>0 && curmaxnum>0){
					curmaxnum--;
				}
			}
			maxnum = Math.max(maxnum, curmaxnum + samenum);
		}
		return maxnum;
	}

}


class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}