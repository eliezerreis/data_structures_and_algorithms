package trees;

import trees.tree.Tree;

public class BinarySearchTreeApp {

    public Tree create(int[] nums) {
        Tree tree = new Tree();
        for (int i = 0; i < nums.length; i++) {
            tree.insert(nums[i]);
        }
        return tree;
    }

    public static void main(String[] args) {
        BinarySearchTreeApp binaryTree = new BinarySearchTreeApp();
        var nums = new int[]{20, 35, -15, 7, 55, -22, 1};

        Tree tree = binaryTree.create(nums);
        tree.transverseInOrder();

        System.out.println();
        System.out.println("Get:" + tree.get(-15));
        System.out.println("Get:" + tree.get(22));
        System.out.println("Get:" + tree.get(1));

        System.out.println();
        System.out.println("Min:" + tree.min());
        System.out.println("Max:" + tree.max());

        System.out.println("");
        tree.delete(-22);
        tree.delete(-15);
        tree.delete(7);
        tree.transverseInOrder();

        System.out.println();
    }
}
