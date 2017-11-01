package com.lzh.utils.leetCode;

/**
 * 二叉树任意一个节点其左子树深度与右子树深度相差不大于1
 * 
 * */
public class BalancedBinaryTree_110 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root1 = new TreeNode(1);
		TreeNode root2 = new TreeNode(2);
		TreeNode root3 = new TreeNode(2);
		TreeNode root4 = new TreeNode(3);
		TreeNode root5 = new TreeNode(3);
		TreeNode root6 = new TreeNode(4);
		TreeNode root7 = new TreeNode(4);
		root1.left = root2;
		root1.right = root3;
		root2.left = root4;
		root2.right = root5;
		root3.left = root6;
		root3.right = root7;
		System.out.println(isBalanced(root1));
	}

    public static boolean isBalanced(TreeNode root) {
    	if(root ==null )
    		return true;
    	if(root.left == null && root.right == null)
    		return true;
        return check(root.left, root.right);
    }
    
    public static boolean hasChild(TreeNode root){
    	return (root.left != null || root.right != null);
    }
    
    public static boolean check(TreeNode root1,TreeNode root2){
    	if(root1==null && root2 == null)
    		return false;
    	if(root1 == null ){
    		return !check(root2.left,root2.right);
    	}
    	if(root2 == null ){
    		return !check(root1.left,root1.right);
    	}
    	return !(check(root1.left, root2.left) && check(root1.right, root2.right));
    }

}
