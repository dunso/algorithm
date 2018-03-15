public class LeetCode0109 {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private ListNode current;

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		int size = 0;
		current = head;
		for (ListNode p = head; p != null; p = p.next) {
			size++;
		}

		return dfs(head, size);
	}

	private TreeNode dfs(ListNode head, int size) {

		if (size == 0) {
			return null;
		}

		TreeNode left = dfs(head, size / 2);
		TreeNode root = new TreeNode(current.val);
		current = current.next;
		TreeNode right = dfs(head, size - size / 2 - 1);
		root.left = left;
		root.right = right;
		return root;
	}
}