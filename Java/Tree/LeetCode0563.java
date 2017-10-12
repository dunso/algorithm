public class LeetCode0563 {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int findTilt(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int[] result = new int[1];
		handleSub(root, result);
		return result[0];
	}

	private int handleSub(TreeNode root, int[] result) {
		if (root == null) {
			return 0;
		}

		int l = handleSub(root.left, result);
		int r = handleSub(root.right, result);

		result[0] += Math.abs(l - r);

		return l + r + root.val;
	}
}
