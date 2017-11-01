package com.lzh.utils.leetCode;

public class SameTree_100 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public static boolean isSameTree(TreeNode p, TreeNode q) {
    	if(p==null && q==null)
    		return true;
        if(p.val!=q.val)
        	return false;
        if(isSameTree(p.left, q.left) && isSameTree(p.right, q.right))
        	return true;
        return false;
    }

}