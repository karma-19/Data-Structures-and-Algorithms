package tree;


public class Height {
    public int getHeight(Main.TreeNode root)  {
        if(root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
