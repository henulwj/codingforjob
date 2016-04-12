package codingforjob.leetcode;

/*
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */

/***
 * 思路：递归循环调用
 * @author lwj
 *
 */


public class LeetCode104MaximumDepthofBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
//		root.right = new TreeNode(2);
		root.left.left = new TreeNode(2);
		int maxdepth = getMaxDepth(root);
		System.out.println(maxdepth);
		
	}
	
	
	public static int getMaxDepth(TreeNode root){
		int maxleft = 0, maxright = 0;
		if(root!=null){
			maxleft = getMaxDepth(root.left)+1;
			maxright = getMaxDepth(root.right)+1;
		}
		return maxleft > maxright ? maxleft : maxright;
		
		
	}

}
