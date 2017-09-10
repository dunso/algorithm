
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode0226 {

	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return root;
		}

		TreeNode tmp = invertTree(root.left);
		root.left = invertTree(root.right);
		root.right = tmp;

		return root;
	}

	public static void main(String[] args) throws IOException {
		LeetCode0226 leetcode = new LeetCode0226();

		TreeNode root = TreeNode.stringToTreeNode("[1, 3, null]");

		TreeNode ret = leetcode.invertTree(root);

		String out = TreeNode.treeNodeToString(ret);

		System.out.println(out);
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		static TreeNode stringToTreeNode(String input) {
			input = input.trim();
			input = input.substring(1, input.length() - 1);
			if (input.length() == 0) {
				return null;
			}

			String[] parts = input.split(",");
			String item = parts[0];
			TreeNode root = new TreeNode(Integer.parseInt(item));
			Queue<TreeNode> nodeQueue = new LinkedList<>();
			nodeQueue.add(root);

			int index = 1;
			while (!nodeQueue.isEmpty()) {
				TreeNode node = nodeQueue.remove();

				if (index == parts.length) {
					break;
				}

				item = parts[index++];
				item = item.trim();
				if (!item.equals("null")) {
					int leftNumber = Integer.parseInt(item);
					node.left = new TreeNode(leftNumber);
					nodeQueue.add(node.left);
				}

				if (index == parts.length) {
					break;
				}

				item = parts[index++];
				item = item.trim();
				if (!item.equals("null")) {
					int rightNumber = Integer.parseInt(item);
					node.right = new TreeNode(rightNumber);
					nodeQueue.add(node.right);
				}
			}
			return root;
		}

		static String treeNodeToString(TreeNode root) {
			String output = "";
			Queue<TreeNode> nodeQueue = new LinkedList<>();
			nodeQueue.add(root);
			while (!nodeQueue.isEmpty()) {
				TreeNode node = nodeQueue.remove();

				if (node == null) {
					output += "null, ";
					continue;
				}

				output += String.valueOf(node.val) + ", ";
				nodeQueue.add(node.left);
				nodeQueue.add(node.right);
			}
			return "[" + output.substring(0, output.length() - 2) + "]";
		}
	}
}