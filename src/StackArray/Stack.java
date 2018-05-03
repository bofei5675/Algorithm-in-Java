package StackArray;

public class Stack<T> {
    private T[] stack;
    private int numOfItems;

    public Stack() {
        this.stack = (T[]) new Object[1];
    }

    public void push(T newData) {
        // check if the array is full
        if (this.numOfItems == this.stack.length) {
            this.resize(2 * this.stack.length);
        }
        this.stack[this.numOfItems++] = newData;
    }

    private void resize(int capacity) {
        T[] newStack = (T[]) new Object[capacity];
        for (int i = 0; i < this.numOfItems; i++) {
            newStack[i] = this.stack[i];
        }
        this.stack = newStack;

    }

    public boolean isEmpty() {
        return this.numOfItems == 0;

    }

    public int size() {
        return this.numOfItems;
    }

    public T pop() {
        T itemToPop = this.stack[--this.numOfItems];
        // if the size is not empty and size is 25% of capacity
        if (this.numOfItems > 0 && this.numOfItems == this.stack.length / 4) {
            this.resize(this.stack.length / 2);
        }
        return itemToPop;
    }

    public void showContent() {
        for (int i = 0; i < this.numOfItems; i++) {
            System.out.print(this.stack[i] + " - ");
        }
        System.out.println(' ');
    }
}
