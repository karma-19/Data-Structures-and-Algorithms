package tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    LevelOrderTraversal(Main.TreeNode root, boolean withQueue) {
        if(withQueue) {
            printLevelOrderTraversal(root);
        } else {
            Height height = new Height();
            int level = height.getHeight(root);
            printLevelOrderTraversal(root, level);
        }
    }

    //using queue
    private void printLevelOrderTraversal(Main.TreeNode root) {
        if(root==null) return;

        Queue<Main.TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            Main.TreeNode node = q.poll();
            System.out.print(node.val + " ");

            if(node.left != null) {
                q.offer(node.left);
            }

            if(node.right != null) {
                q.offer(node.right);
            }
        }
    }

    //without using queue
    private void printLevelOrderTraversal(Main.TreeNode root, int level) {
        for(int i=1; i<=level; i++) printCurrentLevel(root, i);
    }

    private void printCurrentLevel(Main.TreeNode root, int level) {
        if(root == null) {
            return;
        } else if(level == 1) {
            System.out.print(root.val + " ");
        } else if(level > 1){
            printCurrentLevel(root.left, level-1);
            printCurrentLevel(root.right, level-1);
        }
    }
}
