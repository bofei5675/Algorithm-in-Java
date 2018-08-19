package MyCircularQueue;

public class MyCircularQueue {
    int[] a;
    int start, end, len;

    public MyCircularQueue(int k) {
        this.a = new int[k];
        this.start = this.end = -1;
    }

    public boolean isFull() {
        return this.len == this.a.length;
    }

    public boolean isEmpty() {
        return this.len == 0;
    }

    public boolean enQueue(int value) {
        if (!this.isFull()) {
            this.end = (this.end + 1) % this.a.length;
            this.a[this.end] = value;
            this.len++;
            return true;
        }

        return false;
    }

    public boolean deQueue() {
        if (!this.isEmpty()) {
            this.start = (this.start + 1) % this.a.length;
            this.len--;

            return true;
        }
        return false;
    }

    public int Front() {
        return this.isEmpty() ? -1 : this.a[this.start];
    }

    public int Rear() {
        return this.isEmpty() ? -1 : this.a[this.end];
    }

    @Override
    public String toString() {
        String output = "";

        for (int i = 0; i < this.a.length; i++) {
            output += this.a[i] + " ";
        }
        return output;
    }
}
