package AVLTree;

public class AVLTree<T extends Comparable<T>> implements Tree<T> {
    private Node root;

    public int height(Node<T> node) {
        if (node == null) {
            return -1;
        }
        return node.getHeight();
    }

    private Node rightRotation(Node<T> node) {
        System.out.println("Right rotation here ...");
        // get left child
        Node<T> tempLeftNode = node.getLeftNode();
        // the right child of left child should be moved to left child of node
        Node<T> t = tempLeftNode.getRightNode();
        // do the rotation
        tempLeftNode.setRightNode(node);
        node.setLeftNode(t);

        node.setHeight(Math.max(node.getLeftNode().getHeight(),
                node.getRightNode().getHeight() + 1));
        tempLeftNode.setHeight(Math.max(tempLeftNode.getLeftNode().getHeight(),
                tempLeftNode.getRightNode().getHeight() + 1));
        // return the new root;
        return tempLeftNode;
    }

    public int getBalance(Node<T> node) {
        // compute if the tree is balanced.
        if (node == null) {
            return 0;
        }
        return this.height(node.getLeftNode())
                - this.height(node.getRightNode());
    }

    @Override
    public void insert(T data) {
        // TODO Auto-generated method stub

    }

    @Override
    public void traverse() {
        // TODO Auto-generated method stub
        if (this.root == null) {
            return;
        }
        this.inOrderTranverse(this.root);
    }

    private void inOrderTranverse(Node<T> node) {
        if (node.getLeftNode() != null) {
            this.inOrderTranverse(node.getLeftNode());
        }
        System.out.println(node.getData().toString());
        if (node.getRightNode() != null) {
            this.inOrderTranverse(node.getRightNode());
        }

    }

}
