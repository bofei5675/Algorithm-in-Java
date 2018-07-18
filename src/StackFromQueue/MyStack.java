package StackFromQueue;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Leetcode 225
 * Implementation of Stack by two Queue
 *
 */
class MyStack {
    public Queue<Integer> ls1;
    public Queue<Integer> ls2;

    /** Initialize your data structure here. */
    public MyStack() {
        this.ls1 = new LinkedList<>();
        this.ls2 = new LinkedList<>();

    }

    /** Push element x onto stack. */
    public void push(int x) {
        if (this.ls1.isEmpty()) {
            this.ls1.add(x);

            while (!this.ls2.isEmpty()) {
                this.ls1.add(this.ls2.poll());
            }
        } else {
            this.ls2.add(x);

            while (!this.ls1.isEmpty()) {
                this.ls2.add(this.ls1.poll());
            }
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return (this.ls1.isEmpty()) ? this.ls2.poll() : this.ls1.poll();
    }

    /** Get the top element. */
    public int top() {
        return (this.ls1.isEmpty()) ? this.ls2.peek() : this.ls1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return this.ls1.size() == 0 && this.ls2.size() == 0;
    }

    @Override
    public String toString() {
        String output = "[";
        for (Integer i : this.ls1) {
            output += String.valueOf(i) + ",";
        }

        output += "]";
        return output;

    }

    public static void main(String[] args) {
        MyStack stk = new MyStack();

        stk.push(1);
        stk.push(2);
        stk.push(3);
        System.out.println(stk);
        System.out.println(stk.pop());
        System.out.println(stk);
    }
}

/**
 * Your MyStack object will be instantiated and called as such: MyStack obj =
 * new MyStack(); obj.push(x); int param_2 = obj.pop(); int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
