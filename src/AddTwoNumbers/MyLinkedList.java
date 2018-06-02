package AddTwoNumbers;

public class MyLinkedList<T extends Comparable<T>> {
    private Node root;

    public MyLinkedList() {

    }

    public Node getRoot() {
        return this.root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void insert(T data) {
        if (this.root == null) {
            this.root = new Node(data);
        } else {
            this.insert(this.root, data);
        }
    }

    public void insert(Node node, T data) {
        if (node.getNext() == null) {
            Node nextNode = new Node(data);
            node.setNext(nextNode);
        } else {
            this.insert(node.getNext(), data);
        }
    }

    public void display() {
        Node node = this.root;
        while (node != null) {
            System.out.print(node.getData() + "->");
            node = node.getNext();
        }
        System.out.println(" ");
    }
}
