package codingforjob.leetcode;

/*
Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */

/***
 * 思路：递归遍历循环
 * @author lwj
 *
 */

public class LeetCode100SameTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode p = null;
		TreeNode q = null;
		System.out.println(isSameTree(p, q));
	}

	
	public static boolean isSameTree(TreeNode p, TreeNode q){
		if(p == null && q == null){
			return true;
		}
		if(p == null && q != null){
			return false;
		}
		if(p != null && q == null){
			return false;
		}
		if(p.val != q.val){
			return false;
		}
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
}
