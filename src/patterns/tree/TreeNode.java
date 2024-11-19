package patterns.tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    // Constructor for creating a tree node with a value
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
