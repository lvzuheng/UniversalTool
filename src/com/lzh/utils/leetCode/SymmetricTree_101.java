package com.lzh.utils.leetCode;

import java.util.LinkedList;
import java.util.Queue;

import com.lzh.utils.net.netMain;

public class SymmetricTree_101 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root1 = new TreeNode(1);
		TreeNode root2 = new TreeNode(2);
		TreeNode root3 = new TreeNode(2);
		TreeNode root4 = new TreeNode(3);
		TreeNode root5 = new TreeNode(2);
		TreeNode root6 = new TreeNode(3);
		TreeNode root7 = new TreeNode(3);
		root1.left = root2;
		root1.right = root3;
//		root2.left = root4;
		root2.right = root5;
//		root3.left = root6;
		root3.right = root7;
		System.out.println(isSymmetric(root1));
	}
	public static boolean isSymmetric(TreeNode root) {
		
		if(root ==null)
			return false;
		return chaile(root.left, root.right);

	}
	
	public static boolean chaile(TreeNode rNode1,TreeNode rNode2){
		if(rNode1 ==null && rNode2==null){
			return true;
		}else if((rNode1==null && rNode2!=null) || (rNode1!=null && rNode2==null)){
			return false;
		}else if(rNode2.val !=rNode1.val){
			return false;
		}
		return chaile(rNode1.left, rNode2.right)&& chaile(rNode1.right, rNode2.left);
	}
}
