package trees;

import trees.util.BinaryTree;

public class BinarySearchTreeApp {

    public static void main(String[] args) {
        var nums = new int[]{20, 35, -15, 7, 55, -22, 1};

        BinaryTree tree = BinaryTree.createTree(nums);
        tree.transverseInOrder();

        System.out.println();
        tree.transversePreOrder();

        System.out.println();
        tree.transversePosOrder();

        System.out.println();
        System.out.println("Get:" + tree.get(-15));
        System.out.println("Get:" + tree.get(22));
        System.out.println("Get:" + tree.get(1));

        System.out.println();
        System.out.println("Min:" + tree.min());
        System.out.println("Max:" + tree.max());

        System.out.println();
        tree.delete(-22);
        tree.delete(-15);
        tree.delete(7);
        tree.transverseInOrder();

        System.out.println();
    }
}
