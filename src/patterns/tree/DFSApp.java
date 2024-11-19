package patterns.tree;

import trees.util.SimpleTree;
import trees.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class DFSApp {
    public int smallestPath(TreeNode node) {
        if (node == null)
            return 0;

        if (node.left == null) {
            return 1 + smallestPath(node.right);
        } else if (node.right == null) {
            return 1 + smallestPath(node.left);
        }

        int left = smallestPath(node.left);

        int right = smallestPath(node.right);

        return Math.min(left, right) + 1;
    }

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helper(root, root.val, root.val);
    }

    public int helper(TreeNode node, int curMax, int curMin) {
        if (node == null) {
            return curMax - curMin;
        }

        curMax = Math.max(curMax, node.val);
        curMin = Math.min(curMin, node.val);
        int left = helper(node.left, curMax, curMin);
        int right = helper(node.right, curMax, curMin);
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        DFSApp app = new DFSApp();
        Integer[] arr1 = {3, 9, 20, null, null, 15, 7};
        Integer[] arr2 = {8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13};

        TreeNode root1 = SimpleTree.createTree(arr1);
        TreeNode root2 = SimpleTree.createTree(arr2);

        System.out.println(app.smallestPath(root1));
        System.out.println(app.maxAncestorDiff(root2));
    }



}
