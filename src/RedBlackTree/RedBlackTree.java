package RedBlackTree;

public class RedBlackTree<T extends Comparable<T>> implements Tree<T> {
    private Node<T> root;

    @Override
    public void traverse() {
        // TODO Auto-generated method stub
        if (this.root != null) {
            this.inOrderTraversal(this.root);
        }

    }

    private void inOrderTraversal(Node<T> node) {
        // TODO Auto-generated method stub
        if (node.getLeftNode() != null) {
            this.inOrderTraversal(node.getLeftNode());

        }
        System.out.println("moving to the node " + node);
        if (node.getRightNode() != null) {
            this.inOrderTraversal(node.getRightNode());
        }

    }

    @Override
    public void insert(T data) {
        // TODO Auto-generated method stub
        Node node = new Node<T>(data);
        this.root = this.insert(this.root, node);
        // this.root.setColor(NodeColor.RED);
        this.fixViolation(node);
    }

    private Node<T> insert(Node<T> root, Node<T> node) {
        // TODO Auto-generated method stub
        if (root == null) {

            return node;
        }

        if (node.getData().compareTo(root.getData()) > 0) {
            root.setRightNode(this.insert(root.getRightNode(), node));
            root.getRightNode().setParent(root);
        } else {
            root.setLeftNode(this.insert(root.getLeftNode(), node));
            // update parent relations
            root.getLeftNode().setParent(root);
        }
        return root;
    }

    private void fixViolation(Node<T> node) {
        // TODO Auto-generated method stub
        Node<T> parentNode = null;
        Node<T> grandParentNode = null;

        while (node != this.root && node.getColor() != NodeColor.BLACK
                && node.getParent().getColor() == NodeColor.RED) {
            System.out.println("Fix at node " + node + " " + node.getColor());
            parentNode = node.getParent();
            System.out.println(
                    "Parent node " + parentNode + " " + parentNode.getColor());
            grandParentNode = node.getParent().getParent();
            System.out.println("GrandParent node " + grandParentNode);
            if (parentNode == this.root) {
                node.setColor(NodeColor.BLACK);
                break;
            }
            if (parentNode == grandParentNode.getLeftNode()) {
                Node<T> uncle = grandParentNode.getRightNode();
                if (uncle != null && uncle.getColor() == NodeColor.RED) {
                    uncle.setColor(NodeColor.BLACK);
                    parentNode.setColor(NodeColor.BLACK);
                    grandParentNode.setColor(NodeColor.RED);

                    // move node
                    node = grandParentNode;
                } else {
                    if (node == node.getParent().getRightNode()) {
                        this.leftRotation(parentNode);
                        // update reference for parents
                        node = parentNode;
                        parentNode = node.getParent();
                    }
                    /*
                     * if not the right children do right rotation at first if
                     * it is, do left then do right
                     */
                    this.rightRotation(grandParentNode);
                    NodeColor tempColor = parentNode.getColor();
                    parentNode.setColor(grandParentNode.getColor());
                    grandParentNode.setColor(tempColor);
                    node = parentNode;
                }
            } else {
                Node<T> uncle = grandParentNode.getLeftNode();

                if (uncle != null && uncle.getColor() == NodeColor.RED) {
                    // Case I do the re coloring
                    uncle.setColor(NodeColor.BLACK);
                    parentNode.setColor(NodeColor.RED);
                    grandParentNode.setColor(NodeColor.RED);
                } else {
                    if (node == node.getParent().getLeftNode()) {
                        this.rightRotation(parentNode);
                        // continue to move upward ...
                        node = parentNode;
                        parentNode = node.getParent();
                    }
                    this.leftRotation(grandParentNode);
                    NodeColor tempColor = parentNode.getColor();
                    parentNode.setColor(grandParentNode.getColor());
                    grandParentNode.setColor(tempColor);
                    node = parentNode;
                }

            }
            if (this.root.getColor() == NodeColor.BLACK) {
                this.root.setColor(NodeColor.BLACK);
            }
        }
    }

    private void rightRotation(Node<T> node) {
        Node<T> leftNode = node.getLeftNode();
        node.setLeftNode(leftNode.getRightNode());

        if (node.getLeftNode() != null) {
            node.getLeftNode().setParent(node);
        }

        leftNode.setParent(node.getParent());
        if (leftNode.getParent() == null) {
            this.root = leftNode;
        } else if (node == node.getParent().getLeftNode()) {
            node.getParent().setLeftNode(leftNode);
        } else if (node == node.getParent().getRightNode()) {
            node.getParent().setRightNode(leftNode);
        }

        leftNode.setRightNode(node);
        node.setParent(leftNode);
    }

    private void leftRotation(Node<T> node) {
        System.out.println("Left rotation on the node " + node);
        Node<T> rightNode = node.getRightNode();
        node.setRightNode(rightNode.getLeftNode());

        if (node.getRightNode() != null) {
            node.getRightNode().setParent(node);
        }

        rightNode.setLeftNode(node);
        if (node == node.getParent().getLeftNode()) {
            node.getParent().setLeftNode(rightNode);

        } else if (node == node.getParent().getRightNode()) {
            node.getParent().setRightNode(rightNode);
        } else if (node.getParent() == null) {
            this.root = rightNode;
        }
        rightNode.setLeftNode(node);
        node.setParent(rightNode);
    }

}
