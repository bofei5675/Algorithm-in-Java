package Heap;

public class Heap {
    private Integer[] heap;
    private int currentPosition = -1;

    public Heap(int size) {
        this.heap = new Integer[size];
    }

    // insert an item
    public void insert(int item) {
        if (this.isFull()) {
            throw new RuntimeException("This heap is full");
        }
        this.heap[++this.currentPosition] = item;
        this.fixUp(this.currentPosition);
    }

    private void fixUp(int index) {
        // TODO Auto-generated method stub
        // check if heap properties is kept
        // maximum heap, the root is the max value
        int parentIndex = (index - 1) / 2;
        while (parentIndex >= 0 && this.heap[parentIndex] < this.heap[index]) {
            int temp = this.heap[parentIndex];
            this.heap[parentIndex] = this.heap[index];
            this.heap[index] = temp;
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    public int getMax() {
        // max item at index 0 for max heap
        int result = this.heap[0];
        this.heap[0] = this.heap[this.currentPosition--];
        this.heap[this.currentPosition + 1] = null;
        this.fixDown(0, -1);
        return result;
    }

    public void heapsort() {
        for (int i = 0; i < this.currentPosition; i++) {
            // find the max item
            int temp = this.heap[0];
            // print the max
            System.out.println(temp + " ");
            this.heap[0] = this.heap[this.currentPosition - i];
            this.heap[this.currentPosition - i] = temp;
            // consider the last item is sorted
            this.fixDown(0, this.currentPosition - i - 1);

        }
    }

    private void fixDown(int index, int upto) {
        // TODO Auto-generated method stub
        if (upto < 0) {
            upto = this.currentPosition;
        }
        while (index < upto) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;

            if (leftChild < upto) {
                int childToSwap;
                if (rightChild > upto) {
                    childToSwap = leftChild;
                } else {
                    childToSwap = (this.heap[leftChild] > this.heap[rightChild])
                            ? leftChild
                            : rightChild;
                }
                if (this.heap[index] < this.heap[childToSwap]) {
                    int temp = this.heap[childToSwap];
                    this.heap[childToSwap] = this.heap[index];
                    this.heap[index] = temp;
                    index = childToSwap;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
    }

    private boolean isFull() {
        // TODO Auto-generated method stub
        return this.currentPosition == this.heap.length;
    }
}
