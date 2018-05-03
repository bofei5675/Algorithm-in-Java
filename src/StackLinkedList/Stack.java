package StackLinkedList;

public class Stack<T extends Comparable<T>> {
    public Node<T> root;
    public int count;

    public void push(T newData) {
        this.count++;
        if (this.root == null) {
            this.root = new Node<>(newData);
        } else {
            Node newNode = new Node<>(newData);
            newNode.setNextNode(this.root);
            this.root = newNode;
        }
    }

    /*
     * All running as linear running time but memory complexity is a trade-off
     */
    public int size() {
        return this.count;
    }

    public boolean isEmpty() {
        /*
         * Not the best option if (this.count == 0) { return true; } else {
         * return false; }
         */
        return this.root == null;
    }

    public T pop() {
        // check if the stack is empty
        T itemToPoped = this.root.getData();
        this.root = this.root.getNextNode();
        this.count--;

        return itemToPoped;
    }

    public T peek() {
        return this.root.getData();
    }
}
