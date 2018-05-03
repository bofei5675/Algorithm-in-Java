package StackLinkedList;

public class Node<T extends Comparable<T>> {
    private T data;
    private Node<T> nextNode;

    public Node(T data) {
        this.data = data;
    }

    /*
     * Get and setter functions
     */
    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNextNode() {
        return this.nextNode;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

}
