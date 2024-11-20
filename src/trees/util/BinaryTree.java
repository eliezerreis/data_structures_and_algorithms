package trees.util;

public class BinaryTree {

    public BinaryNode root;

    public static BinaryTree createTree(int[] nums) {
        BinaryTree tree = new BinaryTree();
        for (int num : nums) {
            tree.insert(num);
        }
        return tree;
    }

    public void insert(int value) {
        if (root == null)
            root = new BinaryNode(value);
        else
            root.insert(value);
    }

    public void transverseInOrder() {
        if (root != null)
            root.transverseInOrder();

    }

    public void transversePreOrder() {
        if (root != null)
            root.transversePreOrder();
    }

    public void transversePosOrder() {
        if (root != null)
            root.transversePosOrder();
    }


    public BinaryNode get(int value) {
        if (root != null)
            return root.get(value);

        return null;
    }

    public int min() {
        if (root == null)
            return Integer.MIN_VALUE;

        return root.min();
    }

    public int max() {
        if (root == null)
            return Integer.MAX_VALUE;

        return root.max();
    }

    public void delete(int value) {
        root = delete(root, value);
    }

    private BinaryNode delete(BinaryNode node, int value) {
        if (node == null) return null;

        if (value < node.getVal()) {
            node.setLeft(delete(node.getLeft(), value));
        } else if (value > node.getVal()) {
            node.setRight(delete(node.getRight(), value));
        } else {
            // Case 1: Node has no left child
            if (node.getLeft() == null) {
                return node.getRight();
            }
            // Case 2: Node has no right child
            else if (node.getRight() == null) {
                return node.getLeft();
            }
            // Case 3: Node has two children
            else {
                // Get the smallest value in the right of the subtree
                node.setVal(node.getRight().min());

                // Delete the successor node
                node.setRight(delete(node.getRight(), node.getVal()));
            }
        }

        return node;
    }
}
