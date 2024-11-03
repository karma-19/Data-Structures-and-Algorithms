package tree;

public class LeftView {

    LeftView(Main.TreeNode root) {
        printLeftView(root);
    }

    private void printLeftView(Main.TreeNode root) {
        if(root == null) return;

        System.out.print(root.val + " ");
        if(root.left != null) {
            printLeftView(root.left);
        } else if(root.right != null) {
            printLeftView(root.right);
        }
    }
}
