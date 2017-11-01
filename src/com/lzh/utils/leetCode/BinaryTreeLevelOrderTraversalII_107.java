package com.lzh.utils.leetCode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII_107 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	if(root == null)
    		return null;
    	List<List<Integer>> iList  = new ArrayList<>();
    	
    	iList.addAll(levelOrderBottom(root.left));
    	iList.addAll(levelOrderBottom(root.right));
    
    	
    	return iList;
    }
}
