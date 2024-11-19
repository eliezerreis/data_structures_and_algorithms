package trees.util;

public class BinaryNode {
    private int data;
    private BinaryNode right;
    private BinaryNode left;

    public BinaryNode(int data) {
        this.data = data;
    }


    public void insert(int value) {
        if (value == data)
            return;

        if (value < data) {
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

        System.out.print(data + " ");

        if (right != null)
            right.transverseInOrder();
    }

    public void transversePreOrder() {
        System.out.print(data + " ");
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
        System.out.print(data + " ");
    }

    public BinaryNode get(int value) {
        if (data == value) return this;

        if (value < data) {
            if (left != null) return left.get(value);
        } else {
            if (right != null) return right.get(value);
        }

        return null;
    }

    public int min() {
        if (left == null) return data;
        else return left.min();
    }

    public int max() {
        if (right == null) return data;
        else return right.max();
    }

    @Override
    public String toString() {
        return "BinaryNode{" + "data=" + data + '}';
    }


    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
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
