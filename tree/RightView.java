package tree;

public class RightView {
    RightView(Main.TreeNode root) {
        printRightView(root);
    }

    public void printRightView(Main.TreeNode root) {
        if(root == null) return ;

        System.out.print(root.val + " ");
        if(root.right != null) {
            printRightView(root.right);
        } else if(root.left != null){
            printRightView(root.left);
        }
    }
}
