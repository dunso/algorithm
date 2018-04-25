public class LeetCode0112 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean hasPathSum(TreeNode root, int sum) {
		return dfs(root, 0, sum);
	}

	private boolean dfs(TreeNode root, int current, int sum) {
		if (root == null) {
			return false;
		}
		if (root.left == null && root.right == null) {
			if (current + root.val == sum) {
				return true;
			}
			return false;
		}
		return dfs(root.left, current + root.val, sum) || dfs(root.right, current + root.val, sum);
	}
}