package SplayTree;

public class SplayTree<T extends Comparable<T>> implements Tree<T> {
    private Node<T> root;
    private int size;

    @Override
    public void insert(T data) {
        // TODO Auto-generated method stub
        Node<T> tempNode = this.root;
        Node<T> parentNode = null;
        // move the reference until it reaches null
        while (tempNode != null) {
            parentNode = tempNode;
            if (tempNode.getData().compareTo(data) < 0) {
                tempNode = tempNode.getRightChild();
            } else {
                tempNode = tempNode.getLeftChild();
            }

        }
        // insert this node here
        tempNode = new Node<T>(data);
        tempNode.setParent(parentNode);
        if (parentNode == null) {
            this.root = tempNode;
        } else if (tempNode.getData().compareTo(parentNode.getData()) > 0) {
            parentNode.setRightChild(tempNode);
        } else {
            parentNode.setLeftChild(tempNode);
        }
        this.splay(tempNode);
        this.size++;
    }

    private void splay(Node<T> node) {
        // TODO Auto-generated method stub
        while (node != null) {
            /*
             * Zig situation given nodes is left child or right child of root
             */
            if (node.getParent().getParent() == null) {
                // if it is left child or right child?
                if (node == node.getParent().getLeftChild()) {
                    this.rightRotation(node.getParent());
                } else if (node == node.getParent().getRightChild()) {
                    this.leftRotation(node.getParent());
                }
                // then this node is the root node
            }
            /*
             * Zig Zig situation This node is left child of left child of grand
             * parent or right child of right child or grandparent.
             */
            else if (node.getParent().getParent().getLeftChild() == node
                    .getParent().getParent()
                    && node.getParent().getLeftChild() == node) {
                this.rightRotation(node.getParent().getParent());
                this.rightRotation(node.getParent());
                // then node is root now
            } else if (node.getParent().getParent().getRightChild() == node
                    .getParent() && node.getParent().getRightChild() == node) {
                this.leftRotation(node.getParent().getParent());
                this.leftRotation(node.getParent());
            }
            /*
             * zig-zag situation This node is left child of right child of
             * grandparents OR this node is right child of left child of
             * grandparents
             */
            else if (node.getParent().getParent().getLeftChild() == node
                    .getParent().getParent()
                    && node.getParent().getRightChild() == node) {
                this.leftRotation(node.getParent());
                this.rightRotation(node.getParent());
            } else if (node.getParent().getParent().getRightChild() == node
                    .getParent() && node.getParent().getLeftChild() == node) {
                this.rightRotation(node.getParent());
                this.leftRotation(node.getParent());
            }
        }
    }

    @Override
    public Node<T> find(T data) {
        // TODO Auto-generated method stub
        Node<T> node = this.root;
        while (node != null) {
            if (node.getData().compareTo(data) > 0) {
                node = node.getLeftChild();
            } else if (node.getData().compareTo(data) < 0) {
                node = node.getRightChild();
            } else {
                this.splay(node);
                return node;
            }
        }
        this.splay(node);
        return null;

    }

    @Override
    public T getMin() {
        if (this.root != null) {
            return this.getMin(this.root);
        }
        return null;
    }

    private T getMin(Node<T> node) {
        // TODO Auto-generated method stub
        if (node.getLeftChild() != null) {
            return this.getMin(node.getLeftChild());
        }
        return node.getData();
    }

    @Override
    public T getMax() {
        // TODO Auto-generated method stub
        if (this.root != null) {
            return this.getMax(this.root);
        }
        return null;
    }

    private T getMax(Node<T> node) {
        // TODO Auto-generated method stub
        if (node.getRightChild() != null) {
            return this.getMax(node.getRightChild());
        }
        return node.getData();
    }

    @Override
    public void inOrderTranverse() {
        // TODO Auto-generated method stub
        if (this.root == null) {
            return;
        }
        this.inOrderTranverse(this.root);
    }

    private void inOrderTranverse(Node<T> node) {
        // TODO Auto-generated method stub
        if (node.getLeftChild() != null) {
            this.inOrderTranverse(node.getLeftChild());
        }
        System.out.println(node + " ");
        if (node.getRightChild() != null) {
            this.inOrderTranverse(node.getRightChild());
        }
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    private void rightRotation(Node<T> node) {
        Node<T> tempNode = node.getLeftChild();
        Node<T> p = tempNode.getRightChild();

        Node<T> parent = node.getParent();

        // right rotation
        if (tempNode != null) {
            tempNode.setRightChild(node);
            node.setLeftChild(p);

            if (p != null) {
                p.setParent(node);
            }
            // update parents

            tempNode.setParent(parent);
        }
        if (node.getParent() == null) {
            this.root = tempNode;
        } else if (node == parent.getLeftChild()) {
            parent.setLeftChild(tempNode);
        } else if (node == parent.getRightChild()) {
            parent.setRightChild(tempNode);
        }

        node.setParent(tempNode);

    }

    private void leftRotation(Node<T> node) {
        Node<T> tempNode = node.getRightChild();
        Node<T> p = tempNode.getLeftChild();
        // left rotation
        Node<T> parent = node.getParent();
        if (tempNode != null) {
            tempNode.setLeftChild(node);
            node.setRightChild(p);
            if (p != null) {
                p.setParent(node);
            }
            tempNode.setParent(parent);
        }
        if (node.getParent() == null) {
            this.root = tempNode;
        } else if (node.getParent().getLeftChild() == node) {
            parent.setLeftChild(tempNode);
        } else if (parent.getRightChild() == node) {
            parent.setRightChild(tempNode);
        }
        node.setParent(tempNode);

    }
}
