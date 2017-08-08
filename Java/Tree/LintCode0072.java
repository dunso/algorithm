public class LintCode0072 {
    class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val)
        {
            this.val = val;
            this.left = this.right = null;
        }
    }
    public TreeNode buildTree(int[] inorder, int[] postorder)
    {
        if (inorder == null || postorder == null)
            return null;
        if (inorder.length == 0 || postorder.length == 0)
            return null;
        if (inorder.length != postorder.length)
            return null;

        TreeNode root = helper(inorder, 0, inorder.length - 1,
            postorder, 0, postorder.length - 1);
        return root;
    }

    private TreeNode helper(int[] inorder, int instart, int inend,
        int[] postorder, int poststart, int postend)
    {

        if (instart > inend || poststart > postend)
            return null;

        int root_val = postorder[postend];
        TreeNode root = new TreeNode(root_val);

        int index = findIndex(inorder, instart, inend, root_val);

        root.left = helper(inorder, instart, index - 1,
            postorder, poststart, poststart + index - instart - 1);

        root.right = helper(inorder, index + 1, inend,
            postorder, poststart + index - instart, postend - 1);
        return root;
    }

    private int findIndex(int[] nums, int start, int end, int target)
    {
        for (int i = start; i <= end; i++) {
            if (nums[i] == target)
                return i;
        }
        return -1;
    }
}
