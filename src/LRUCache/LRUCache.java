package LRUCache;

import java.util.HashMap;

public class LRUCache {

    private int size;
    private HashMap<Integer, Node> dict;
    private DoublyLinkedList linkedList;

    public LRUCache() {
        this.dict = new HashMap<>();
        this.linkedList = new DoublyLinkedList();
    }

    public void put(int id, String value) {
        // if the map already contains this item
        if (this.dict.containsKey(id)) {
            Node node = this.dict.get(id);
            node.setData(value);
            // make this node as the head
            this.update(node);
        }
        // if not add the new node to the linked list
        Node node = new Node(id,value)
        if (this.size < Constants.CAPACITY) {
            this.size ++;
            this.add(node);

        } else {
            // the cache is full
            this.removeTail();
            this.add(node);
        }
    }

    private void add(Node node) {
        // TODO Auto-generated method stub
        node.setBackNode(this.linkedList.getHead());
        node.setFrontNode(null);
        // update last head if existed
        if (this.linkedList.getHead() != null) {
            this.linkedList.getHead().setFrontNode(node);
        }
        // update the new head
        this.linkedList.setHead(node);
        if (this.linkedList.getTail() == null) {
            this.linkedList.setTail(node);
        }
        // update the hash table
        this.dict.put(node.getId(), node);

    }

    private void removeTail() {
        // TODO Auto-generated method stub

    }

    private void update(Node node) {
        // TODO Auto-generated method stub
        Node currentHead = this.linkedList.getHead();
        Node frontNode = node.getFrontNode();
        Node backNode = node.getBackNode();
        if (frontNode != null) {
            frontNode.setBackNode(backNode);
            node.setFrontNode(null);
        }
        if (backNode != null) {
            backNode.setFrontNode(node);
        }
        node.setBackNode(currentHead);
        currentHead.setFrontNode(node);

    }
}
