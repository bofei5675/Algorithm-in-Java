package QueueFromStack;

import java.util.Stack;

public class MyQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public MyQueue() {
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
    }

    public void display() {
        System.out.println(this.s1);
        System.out.println(this.s2);
    }

    public void push(int x) {
        if (this.s1.isEmpty()) {
            this.s1.push(x);
            int[] num = new int[this.s2.size()];
            int i = 0;
            while (!this.s2.isEmpty()) {
                num[i++] = this.s2.pop();
            }

            for (int j = num.length - 1; j >= 0; j--) {
                this.s1.push(num[j]);
            }
        } else if (this.s2.isEmpty()) {
            this.s2.push(x);
            int[] num = new int[this.s1.size()];
            int i = 0;
            while (!this.s1.isEmpty()) {
                num[i++] = this.s1.pop();
            }

            for (int j = num.length - 1; j >= 0; j--) {
                this.s2.push(num[j]);
            }
        }
    }

    public int pop() {
        return this.s1.isEmpty() ? this.s2.pop() : this.s1.pop();
    }

    public int peek() {
        return this.s1.isEmpty() ? this.s2.peek() : this.s1.peek();
    }

    public boolean empty() {
        return this.s1.isEmpty() && this.s2.isEmpty();
    }
}
