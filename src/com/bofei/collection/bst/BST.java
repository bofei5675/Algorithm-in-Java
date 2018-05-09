package com.bofei.collection.bst;

public class BST<T extends Comparable<T>> implements Tree<T> {
    private Node<T> root;

    public BST() {
        // do nothing
    }

    @Override
    public void travel() {
        // TODO Auto-generated method stub
        if (this.root != null) {
            this.inOrderTraversal(this.root);
        }
    }

    private void inOrderTraversal(Node<T> node) {
        // TODO Auto-generated method stub
        if (node.getLeftNode() == null && node.getRightNode() == null) {
            System.out.print(node.getData().toString() + "-");
        } else {
            if (node.getLeftNode() != null) {
                this.inOrderTraversal(node.getLeftNode());
            }
            System.out.print(node.getData().toString() + "-");
            if (node.getRightNode() != null) {
                this.inOrderTraversal(node.getRightNode());
            }
        }
    }

    @Override
    public void insert(T data) {
        // TODO Auto-generated method stub
        if (this.root == null) {
            this.root = new Node<T>(data);
        } else {
            this.insertNode(data, this.root);
        }
    }

    @Override
    public void delete(T data) {
        // TODO Auto-generated method stub
        if (this.root != null) {
            this.root = this.delete(data, this.root);
        }
    }

    private Node<T> delete(T data, Node<T> node) {
        if (node == null) {
            return node;
        }
        if (data.compareTo(node.getData()) < 0) {
            node.setLeftNode(this.delete(data, node.getLeftNode()));

        } else if (data.compareTo(node.getData()) > 0) {
            node.setRightNode(this.delete(data, node.getRightNode()));
        } else {
            // we found the node
            if (node.getLeftNode() == null && node.getRightNode() == null) {
                System.out.println("Removing leave notes");
                return null;
            }
            if (node.getLeftNode() == null) {
                System.out.println("Removing the right child");
                Node tempNode = node.getRightNode();
                node = null;
                return tempNode;
            }
            if (node.getRightNode() == null) {
                System.out.println("Removing the left child");
                Node tempNode = node.getLeftNode();
                node = null;
                return tempNode;
            }
            // this is the case to removing node with two children
            if (node.getLeftNode() != null && node.getRightNode() != null) {
                System.out.print("Removing the node with two children ...");

                Node<T> preNode = this.findPredecessor(node.getLeftNode());
                node.setData(preNode.getData());
                node.setLeftNode(
                        this.delete(preNode.getData(), node.getLeftNode()));

            }
        }
        return node;

    }

    private Node findPredecessor(Node<T> leftNode) {
        // TODO Auto-generated method stub
        if (leftNode.getRightNode() != null) {
            return this.findPredecessor(leftNode.getRightNode());
        }
        return leftNode;
    }

    @Override
    public T getMaxValue() {
        // TODO Auto-generated method stub
        if (this.root == null) {
            return null;
        }

        return this.getMax(this.root);
    }

    @Override
    public T getMinValue() {
        if (this.root == null) {
            return null;
        }

        return this.getMin(this.root);
    }

    private T getMax(Node<T> node) {
        if (node.getRightNode() != null) {
            return this.getMax(node.getRightNode());
        }
        return node.getData();
    }

    private T getMin(Node<T> node) {
        if (node.getLeftNode() != null) {
            return this.getMin(node.getLeftNode());
        }
        return node.getData();
    }

    private void insertNode(T data, Node<T> node) {
        // TODO Auto-generated method stub
        T node_value = node.getData();
        if (data.compareTo(node_value) < 0) {
            if (node.getLeftNode() == null) {
                node.setLeftNode(new Node<T>(data));
            } else {
                this.insertNode(data, node.getLeftNode());
            }
        } else {
            if (node.getRightNode() == null) {
                node.setRightNode(new Node<T>(data));
            } else {
                this.insertNode(data, node.getRightNode());
            }
        }
    }

}
