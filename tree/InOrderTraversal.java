package tree;

public class InOrderTraversal {
    public void inorderTraversal(Main.TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }

    public void inorderTraversalIteration(Main.TreeNode root) {
        
    }
}
