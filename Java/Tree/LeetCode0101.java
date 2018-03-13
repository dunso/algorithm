package com.leetcode.tree;

public class LeetCode0101 {
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	  
	  public boolean isSymmetric(TreeNode root) {
	        if(root == null){
	            return true;
	        }
	        return isSymmetricTree(root.left,root.right);
	    }
	    private boolean isSymmetricTree(TreeNode p, TreeNode q){
	        if(p==null && q==null) {
	        	return true;
	        }
	        if((p==null && q!=null)||(p!=null && q==null)) {
	        	return false;
	        }   
	        if(p.val!= q.val) {
	        	return false;  	
	        }
	        return isSymmetricTree(p.left,q.right) && isSymmetricTree(p.right, q.left);
	    }
}
