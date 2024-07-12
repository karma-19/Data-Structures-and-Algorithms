package tree;

public class Mirror {

    public Main.TreeNode getMirrorTree(Main.TreeNode root) {
        if (root == null) return null;

        Main.TreeNode left = getMirrorTree(root.left);
        Main.TreeNode right = getMirrorTree(root.right);

        root.left = right;
        root.right = left;
        return root;
    }
}
