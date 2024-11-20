package trees.util;

public class BinaryNode {
    public int val;
    public BinaryNode right;
    public BinaryNode left;

    public BinaryNode(int val) {
        this.val = val;
    }

    public void insert(int value) {
        if (value == val)
            return;

        if (value < val) {
            if (left == null)
                left = new BinaryNode(value);
            else
                left.insert(value);
        } else {
            if (right == null)
                right = new BinaryNode(value);
            else
                right.insert(value);
        }

    }

    public void transverseInOrder() {
        if (left != null)
            left.transverseInOrder();

        System.out.print(val + " ");

        if (right != null)
            right.transverseInOrder();
    }

    public void transversePreOrder() {
        System.out.print(val + " ");
        if (left != null)
            left.transversePreOrder();
        if (right != null)
            right.transversePreOrder();
    }

    public void transversePosOrder() {
        if (left != null)
            left.transversePreOrder();
        if (right != null)
            right.transversePreOrder();
        System.out.print(val + " ");
    }

    public BinaryNode get(int value) {
        if (val == value) return this;

        if (value < val) {
            if (left != null) return left.get(value);
        } else {
            if (right != null) return right.get(value);
        }

        return null;
    }

    public int min() {
        if (left == null) return val;
        else return left.min();
    }

    public int max() {
        if (right == null) return val;
        else return right.max();
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }


    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }
}
