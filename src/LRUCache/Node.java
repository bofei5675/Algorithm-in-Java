package LRUCache;

public class Node {
    private Node backNode;
    private Node frontNode;
    private String data;
    private int id;

    public Node() {

    }

    public Node(int id, String data) {
        this.data = data;
        this.id = id;
    }

    public Node getBackNode() {
        return this.backNode;
    }

    public void setBackNode(Node backNode) {
        this.backNode = backNode;
    }

    public Node getFrontNode() {
        return this.frontNode;
    }

    public void setFrontNode(Node frontNode) {
        this.frontNode = frontNode;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
