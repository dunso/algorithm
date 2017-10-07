public class LeetCode0572 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x)
        {
            val = x;
        }
    }

    public boolean isSubtree(TreeNode s, TreeNode t)
    {
        if (t == null && s == null) {
            return true;
        } else if (t == null || s == null) {
            return false;
        }
        return isSubtreeRoot(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean isSubtreeRoot(TreeNode s, TreeNode t)
    {
        if (t == null && s == null) {
            return true;
        } else if (t == null || s == null) {
            return false;
        }
        if (t.val == s.val) {
            return isSubtreeRoot(s.left, t.left) && isSubtree(s.right, t.right);
        }
        return false;
    }
}