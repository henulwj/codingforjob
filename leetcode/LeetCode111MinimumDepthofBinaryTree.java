package codingforjob.leetcode;

/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */

/***
 * 
 * @author lwj
 *
 */

public class LeetCode111MinimumDepthofBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
//		root.left = new TreeNode(1);
		root.right = new TreeNode(1);
//		root.left.left = new TreeNode(1);
		
		System.out.println(getMinDepth(root));
		
	}
	
	public static int getMinDepth(TreeNode root){
		if(root == null){
			return 0;
		}
		else{
			if(null == root.left){
				return getMinDepth(root.right)+1;
			}
			else if(null == root.right){
				return getMinDepth(root.left)+1;
			}
			else{
				return Math.min(getMinDepth(root.left), getMinDepth(root.right))+1;
			}
		}
	}

}
