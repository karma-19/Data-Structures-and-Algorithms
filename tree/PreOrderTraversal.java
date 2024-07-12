package tree;

public class PreOrderTraversal {
    public void preorderTraversal(Main.TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }
}
