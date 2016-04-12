package codingforjob.leetcode;

/*
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
 */

/***
 * 思路：
 * 1、先从前往后遍历判断ratings[i+1]>ratings[i]，然后nums[i+1] = nums[i] + 1;
 * 2、在从后往前遍历判断ratings[i]>ratings[i+1]，注意还要判断nums[i]<=nums[i+1],然后才能nums[i] = nums[i+1] + 1;
 * 3、最后将nums数组遍历相加即为所求
 * @author lwj
 *
 */


public class LeetCode135Candy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ratings = {5,3,1};
		System.out.println(candy(ratings));
	}
	
	public static int candy(int[] ratings){
		int[] nums =  new int[ratings.length]; 
		for (int i = 0; i < nums.length; i++) {
			nums[i] = 1;
		}
		for (int i = 0; i <ratings.length-1; i++) {
			if(ratings[i+1]>ratings[i])
				nums[i+1] = nums[i] + 1;
		}
		int sum = 0;
		for (int i = ratings.length-2; i >= 0 ; i--) {
			sum += nums[i+1];
			if(ratings[i+1]<ratings[i] && nums[i] <=nums[i+1])
				nums[i] = nums[i+1] + 1;
		}
		sum+=nums[0];
		return sum;
	} 

}
