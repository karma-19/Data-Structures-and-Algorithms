package tree;

public class Main {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        //create a tree from array
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(5);
        treeNode.right.right = new TreeNode(6);
        treeNode.left.right.right = new TreeNode(7);
        treeNode.right.right.left = new TreeNode(8);
        treeNode.right.right.left.right = new TreeNode(9);

        System.out.print("Original Preorder Traversal: ");
        PreOrderTraversal preOrderTraversal = new PreOrderTraversal();
        preOrderTraversal.preorderTraversal(treeNode);
        System.out.println();

        System.out.print("Mirror Preorder Traversal: ");
        Mirror mirror = new Mirror();
        preOrderTraversal.preorderTraversal(mirror.getMirrorTree(treeNode));
        System.out.println();

        //***************************************************************************
        System.out.print("Level Order Traversal: ");
        new LevelOrderTraversal(treeNode, true);
        System.out.print(" | ");
        new LevelOrderTraversal(treeNode, false);
        System.out.println();

        //***************************************************************************
        System.out.print("Left View : ");
        new LeftView(treeNode);
        System.out.println();

        //***************************************************************************
        System.out.print("Right View: ");
        new RightView(treeNode);
        System.out.println();

    }
}
