package Queue;

public class Queue<T extends Comparable<T>> {
    private Node<T> firstNode;
    private Node<T> lastNode;
    private int count;

    public boolean isEmpty() {
        return this.firstNode == null;
    }

    public int size() {
        return this.count;
    }

    public void enqueue(T data) {
        this.count++;

        if (this.firstNode == null) {
            Node newNode = new Node<T>(data);
            newNode.setNextNode(null);
            this.firstNode = newNode;
            this.lastNode = newNode;

        } else {
            Node newNode = new Node<T>(data);
            this.lastNode.setNextNode(newNode);
            this.lastNode = newNode;
            this.lastNode.setNextNode(null);
        }
    }

    public T dequeue() {
        this.count--;
        T valueToPop = this.firstNode.getData();
        this.firstNode = this.firstNode.getNextNode();
        if (this.isEmpty()) {
            this.lastNode = null;
        }
        return valueToPop;
    }
}
