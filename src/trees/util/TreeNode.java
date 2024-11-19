package trees.util;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    // Constructor for creating a tree node with a value
    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
