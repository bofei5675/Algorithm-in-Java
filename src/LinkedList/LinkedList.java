package LinkedList;

/*
 * LinkedList Dynamic data structure: keep adding elements, different data types
 * Store items in different sizes constant complexity in adding and removing,
 * copy elements.
 */
public class LinkedList<T extends Comparable<T>> implements List<T> {

    private Node<T> root;
    private int sizeOfList;

    @Override
    public void insert(T data) {
        this.sizeOfList++;

        if (this.root == null) {
            this.root = new Node<T>(data);
        } else {
            this.insertFromBeginning(data);
        }
    }

    // insert from beginning will have O(1)
    private void insertFromBeginning(T data) {
        Node newNode = new Node<>(data);
        newNode.setNextNode(this.root);
        this.root = newNode;

    }

    // insert from end, linear complexity O(N)
    private void insertFromEnd(T data, Node node) {
        if (node.getNextNode() != null) {
            this.insertFromEnd(data, node.getNextNode());
        } else {
            Node newNode = new Node<>(data);
            node.setNextNode(nextNode);

        }
    }

    @Override
    public void remove(T data) {
        if (this.root == null) {
            return;
        }

        this.sizeOfList--;
        if (this.root.getData().compareTo(data) == 0) {
            Node newRoot = this.root.getNextNode();
            this.root = newRoot;
        } else {
            this.remove(data, this.root, this.root.getNextNode());
        }
    }

    private void remove(T data, Node<T> lastNode, Node<T> currentNode) {
        // TODO Auto-generated method stub

        if (currentNode.getData().compareTo(data) == 0) {
            lastNode.setNextNode(currentNode.getNextNode());
            currentNode = null;

        } else if (currentNode.getNextNode() != null) {
            Node nextNode = currentNode.getNextNode();
            this.remove(data, currentNode, nextNode);
        }
    }

    @Override
    public void transverse() {
        // TODO Auto-generated method stub
        if (this.root == null) {
            return;
        }
        Node currentNode = this.root;
        while (currentNode != null) {
            System.out.print(currentNode + " - ");
            currentNode = currentNode.getNextNode();
        }

    }

    @Override
    public int size() {

        return this.sizeOfList;
    }

}
