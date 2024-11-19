package trees.util;

public class Tree {

    public TreeNode root;

    public void insert(int value) {
        if (root == null)
            root = new TreeNode(value);
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


    public TreeNode get(int value) {
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

    private TreeNode delete(TreeNode node, int value) {
        if (node == null) return null;

        if (value < node.getData()) {
            node.setLeft(delete(node.getLeft(), value));
        } else if (value > node.getData()) {
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
                node.setData(node.getRight().min());

                // Delete the successor node
                node.setRight(delete(node.getRight(), node.getData()));
            }
        }

        return node;
    }
}
