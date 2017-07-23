public class LeetCode0105 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int preId;
    private int inId;
    public TreeNode buildTree(int[] preorder, int[] inorder)
    {
        preId = 0;
        inId = 0;
        return buildTree(preorder, inorder, null);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, TreeNode father)
    {
        if (preId >= preorder.length) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preId++]);

        if (inorder[inId] != root.val) {
            root.left = buildTree(preorder, inorder, root);
        }

        inId++;

        if (father == null || inorder[inId] != father.val) {
            root.right = buildTree(preorder, inorder, father);
        }

        return root;
    }
}
