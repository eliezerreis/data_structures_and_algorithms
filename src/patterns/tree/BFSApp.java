package patterns.tree;

import trees.util.SimpleTree;
import trees.util.TreeNode;

import java.util.*;

public class BFSApp {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reversed = true;

        while (!queue.isEmpty()) {

            List<Integer> levelItems = new ArrayList<>();
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (reversed)
                    levelItems.addLast(node.val);
                else
                    levelItems.addFirst(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            reversed = !reversed;
            results.add(levelItems);

        }
        return results;
    }

    private int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int levelTotal = 0;
        while (!queue.isEmpty()) {
            levelTotal = 0;
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                levelTotal += node.val;
                // add elements to the queue
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

        }
        return levelTotal;
    }

    private Integer[] largestEachRow(TreeNode root) {
        List<Integer> results = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int largestNumber = Integer.MIN_VALUE;
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                largestNumber = Math.max(largestNumber, node.val);

                // add elements to the queue
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            results.add(largestNumber);
        }
        return results.toArray(new Integer[0]);
    }

    public static void main(String[] args) {
        BFSApp app = new BFSApp();
        Integer[] arr1 = {1, 3, 2, 5, 3, null, 9};
        Integer[] arr2 = {50, null, 54, 98, 6, null, null, null, 34};
        Integer[] arr3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        TreeNode root1 = SimpleTree.createTree(arr1);
        TreeNode root2 = SimpleTree.createTree(arr2);
        TreeNode root3 = SimpleTree.createTree(arr3);
        List<List<Integer>> zigZag = app.zigzagLevelOrder(root3);

        System.out.println(Arrays.toString(app.largestEachRow(root1))); //1,3,9
        System.out.println(app.deepestLeavesSum(root2)); //34

        for (List<Integer> items : zigZag) {
            System.out.print(items);
        }

    }
}
