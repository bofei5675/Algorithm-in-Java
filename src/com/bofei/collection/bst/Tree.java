package com.bofei.collection.bst;

public interface Tree<T> {
    public void travel();

    public void insert(T data);

    public void delete(T data);

    public T getMaxValue();

    public T getMinValue();

}
