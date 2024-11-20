package patterns.tree;

import trees.util.BinaryNode;
import trees.util.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;


/**
 * This app was created to implement some patterns using Binary Search Tree (BST)
 */
public class BSTApp {

    public int closestValue(BinaryNode root, double target) {
        Queue<Integer> queue = new LinkedList<>();
        traverseInOrder(root, queue);

        double minDiff = Integer.MAX_VALUE;
        int result = 0;
        while(!queue.isEmpty()) {
            int num = queue.poll();
            double diff = Math.abs(num - target);

            if (diff >= minDiff) {
                return result;
            }
            result = num;
            minDiff = diff;
        }

        return result;
    }

    private void traverseInOrder(BinaryNode root, Queue<Integer> queue) {
        if (root == null)
            return;

        traverseInOrder(root.left, queue);
        queue.add(root.val);
        traverseInOrder(root.right, queue);
    }

    public int val(BinaryNode root, double target, boolean movingLeft) {
        if (root == null)
            return 0;

        if (root.val > target) {

        } else {
            closestValue(root.right, target);
        }

        return root.val;
    }

    public BinaryNode insert(BinaryNode root, int val) {
        if (root == null) {
            return new BinaryNode(val);
        }

        if (root.val < val) {
            root = insert(root.right, val);
        } else {
            root = insert(root.left, val);
        }

        return root;
    }


    public boolean isValidBST(BinaryNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean dfs(BinaryNode node, long small, long large) {
        if (node == null) {
            return true;
        }

        if (small >= node.val || node.val >= large) {
            return false;
        }

        boolean left = dfs(node.left, small, node.val);
        boolean right = dfs(node.right, node.val, large);
        return left && right;
    }

    public int rangeSumBST(BinaryNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        int ans = 0;
        if (low <= root.val && root.val <= high) {
            ans += root.val;
        }

        // move left
        if (low < root.val) {
            ans += rangeSumBST(root.left, low, high);
        }

        //move right
        if (root.val < high) {
            ans += rangeSumBST(root.right, low, high);
        }

        return ans;
    }

    public static void main(String[] args) {
        BSTApp app = new BSTApp();
        int[] arr1 = {10, 5, 3, 7, 15, 18};
        int[] arr2 = {4, 2, 1, 3, 7};

        BinaryTree tree1 = BinaryTree.createTree(arr1);
        BinaryTree tree2 = BinaryTree.createTree(arr2);

        System.out.println(app.rangeSumBST(tree1.root, 7, 15));
        System.out.println("It is a valid BST? " + app.isValidBST(tree1.root));

        app.insert(tree2.root, 5);

        System.out.println("It is a valid BST? " + app.isValidBST(tree2.root));

        System.out.println("Closest to target: " + app.closestValue(tree2.root, 3.7));
    }


}
