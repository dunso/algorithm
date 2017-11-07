import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode0144 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int v) {
            val = v;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode p = root;

        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                result.add(p.val);
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                p = p.right;
            }
        }
        return result;
    }
}
