package com.bofei.collection.bst;

public class Node<T extends Comparable<T>> {
    private Node<T> rightNode;
    private Node<T> leftNode;
    private T data;

    public Node(T data) {
        this.data = data;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString() Override the written function for this
     * class so Java knows printing the value of this node.
     */
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

}
