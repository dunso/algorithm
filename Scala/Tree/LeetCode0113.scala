package com.leetcode.tree

class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object LeetCode0113 {
  def pathSum(root: TreeNode, sum: Int): List[List[Int]] = {
    if (root == null || sum == 0) {

    }
    if (root == null) return List();
    var path: List[List[Int]] = List();
    if (root.left != null && sum > root.value) {
      path :::= pathSum(root.left, sum - root.value).map(root.value :: _);
    }
    if (root.right != null && sum > root.value) {
      path :::= pathSum(root.right, sum - root.value).map(root.value :: _);
    }
    path;
  }
}

