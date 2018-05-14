package RedBlackTree;

public class Node<T extends Comparable<T>> {
    private Node<T> rightNode;
    private Node<T> leftNode;
    private T data;
    private NodeColor color;
    private Node<T> parent;

    public Node(T data) {
        this.data = data;
        this.color = NodeColor.RED;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }

    public Node<T> getRightNode() {
        return this.rightNode;
    }

    public void setRightNode(Node<T> rightNode) {
        this.rightNode = rightNode;
    }

    public Node<T> getLeftNode() {
        return this.leftNode;
    }

    public void setLeftNode(Node<T> leftNode) {
        this.leftNode = leftNode;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public NodeColor getColor() {
        return this.color;
    }

    public void setColor(NodeColor color) {
        this.color = color;
    }

    public Node<T> getParent() {
        return this.parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }
}
