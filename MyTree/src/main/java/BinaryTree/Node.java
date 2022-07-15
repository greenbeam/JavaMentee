package BinaryTree;

public class Node {

    private Object data;
    private Node right;
    private Node left;

    Node(Object d) {
        this.data = d;
        this.right = null;
        this.left = null;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }
}
