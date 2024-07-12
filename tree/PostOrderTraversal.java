package tree;

public class PostOrderTraversal {
    public void postorderTraversal(Main.TreeNode root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.print(root.val + " ");
        }
    }
}
