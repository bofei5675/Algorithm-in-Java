package AVLTree;

public class AVLTree<T extends Comparable<T>> implements Tree<T> {
    private Node root;

    @Override
    public void insert(T data) {
        this.root = this.insert(this.root, data);
    }

    private Node insert(Node<T> node, T data) {
        // TODO Auto-generated method stub
        if (node == null) {
            return new Node<T>(data);
        }
        if (data.compareTo(node.getData()) < 0) {
            node.setLeftNode(this.insert(node.getLeftNode(), data));
        } else {
            node.setRightNode(this.insert(node.getRightNode(), data));
        }
        node.setHeight(Math.max(this.height(node.getLeftNode()),
                this.height(node.getRightNode())) + 1);
        node = this.isRotation(node, data);
        return node;
    }

    private Node<T> isRotation(Node<T> node, T data) {
        // TODO Auto-generated method stub
        int balanced = this.getBalance(node);
        // balanced  = left - right
        // left - right > 1 == "heavy left tree" so do right rotation
        // left - right < -1 == "right heavy tree" so do the left rotation
        // case I left-left- left
        if (balanced > 1
                && data.compareTo((T) node.getLeftNode().getData()) < 0) {
            return this.rightRotation(node);
        }
        // case II right-right
        if (balanced < -1
                && data.compareTo((T) node.getRightNode().getData()) > 0) {
            return this.leftRotation(node);
        }
        // case III right-left-right
        if (balanced > 1
                && data.compareTo((T) node.getLeftNode().getData()) > 0) {
            node.setLeftNode(this.leftRotation(node.getLeftNode()));
            return this.rightRotation(node);
        }
        // case IV left-right-left
        if (balanced < -1
                && data.compareTo((T) node.getRightNode().getData()) < 0) {
            node.setRightNode(this.rightRotation(node.getRightNode()));
            return this.leftRotation(node);
        }

        return node;
    }

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

        node.setHeight(Math.max(this.height(node.getLeftNode()),
                this.height(node.getRightNode())) + 1);
        tempLeftNode.setHeight(Math.max(this.height(tempLeftNode.getLeftNode()),
                this.height(tempLeftNode.getRightNode())) + 1);
        // return the new root;
        return tempLeftNode;
    }

    private Node leftRotation(Node<T> node) {
        System.out.println("Left rotation here ...");
        Node<T> tempRightNode = node.getRightNode();
        Node<T> t = tempRightNode.getLeftNode();

        tempRightNode.setLeftNode(node);
        node.setRightNode(t);
        node.setHeight(Math.max(this.height(node.getLeftNode()),
                this.height(node.getRightNode())) + 1);
        tempRightNode
                .setHeight(Math.max(this.height(tempRightNode.getLeftNode()),
                        this.height(tempRightNode.getRightNode())) + 1);
        return tempRightNode;
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

    @Override
    public void delete(T data) {
        if (this.root == null) {
            return;

        }
        this.root = this.delete(this.root, data);
    }

    private Node<T> delete(Node<T> node, T data) {
        if (node == null) {
            return null;
        }
        // look for the node with this value
        if (data.compareTo(node.getData()) < 0) {
            node.setLeftNode(this.delete(node.getLeftNode(), data));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRightNode(this.delete(node.getRightNode(), data));
        } else {
            // case 1 get the leaves node
            if (node.getLeftNode() == null && node.getRightNode() == null) {
                System.out.println("Removing node without any child ...");
                return null;
            }
            // case 2 only has one child
            if (node.getLeftNode() == null && node.getRightNode() != null) {
                System.out.println("Remove one children");
                Node<T> tempNode = node.getRightNode();
                node = null;
                return tempNode;
            }
            if (node.getLeftNode() != null && node.getRightNode() == null) {
                System.out.println("Remove one children");
                Node<T> tempNode = node.getLeftNode();
                node = null;
                return tempNode;
            }
            // case 3
            if (node.getLeftNode() != null && node.getRightNode() != null) {
                System.out.println("Remove the node with two children ...");
                Node<T> newRoot = this.getPredessor(node.getLeftNode());
                node.setData(newRoot.getData());
                node.setLeftNode(
                        this.delete(node.getLeftNode(), newRoot.getData()));
            }

        }
        node.setHeight(Math.max(this.height(node.getLeftNode()),
                this.height(node.getRightNode())) + 1);
        // Check to see if it is balanced
        return this.settleDeletion(node);
    }

    private Node<T> settleDeletion(Node<T> node) {
        // TODO Auto-generated method stub
        int isBalanced = this.getBalance(node);
        if (isBalanced > 1) {
            // left heavy
            if (this.getBalance(node.getLeftNode()) > 1) {
                System.out.println("Left-Left-Left " + node.getData());
                return this.rightRotation(node);
            }
            if (this.getBalance(node.getLeftNode()) < 0) {
                System.out.println("Left-Right-Left " + node.getData());
                Node<T> tempNode = this.leftRotation(node.getLeftNode());
                node.setLeftNode(tempNode);
                return this.rightRotation(node);
            }
        } else if (isBalanced < -1) {
            if (this.getBalance(node.getRightNode()) > 1) {
                System.out.println("Right-Left-Right " + node.getData());
                node.setRightNode(this.rightRotation(node.getRightNode()));
                return this.leftRotation(node);
            }
            // if right-right
            System.out.println("R-R-R " + node.getData());
            return this.leftRotation(node);
        }
        return node;
    }

    private Node<T> getPredessor(Node<T> node) {
        if (node.getLeftNode() == null && node.getRightNode() == null) {
            return node;
        }

        return this.getPredessor(node.getRightNode());
    }

}
