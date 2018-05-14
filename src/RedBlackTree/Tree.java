package RedBlackTree;

public interface Tree<T extends Comparable<T>> {
    public void traverse();

    public void insert(T data);

}
