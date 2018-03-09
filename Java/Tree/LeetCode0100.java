package com.leetcode.tree;

public class LeetCode0100 {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null) {
			if (q == null) {
				return true;
			} else {
				return false;
			}
		}

		if (q == null || p.val != q.val) {
			return false;
		}

		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
}
