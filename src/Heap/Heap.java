package Heap;

public class Heap {
	/**
	 * Binary tree implementation by array for heap
	 * AKA Priority Queue.
	 */
    private Integer[] heap;
    private int currentPosition = -1;

    public Heap(int size) {
    	// initialized array for the given size
        this.heap = new Integer[size];
    }

    // insert an item
    public void insert(int item) {
        if (this.isFull()) {
            throw new RuntimeException("This heap is full");
        }
        
        this.heap[++this.currentPosition] = item;
        this.fixUp(this.currentPosition); // every insert check if heap properties hold
    }
    /**
     * Fix the heap property from the child to parent.
     * @param index
     */
    private void fixUp(int index) {
        // TODO Auto-generated method stub
        // check if heap properties is kept
        // maximum heap, the root is the max value
        int parentIndex = (index - 1) / 2; // how to trace back to parent
        while (parentIndex >= 0 && this.heap[parentIndex] < this.heap[index]) {
            int temp = this.heap[parentIndex];
            this.heap[parentIndex] = this.heap[index];
            this.heap[index] = temp;
            index = parentIndex;
            parentIndex = (index - 1) / 2; // iteration through the heap and keep swap the order
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
    	/**
    	 * o(nlog(n)) running time
    	 * make the heap into sorted array
    	 */
        for (int i = 0; i < this.currentPosition; i++) {
            // find the max item
            int temp = this.heap[0];
            // print the max
            System.out.println(temp + " ");
            // put this element into the correct position.
            this.heap[0] = this.heap[this.currentPosition - i];
            // swap largest with the certain position
            this.heap[this.currentPosition - i] = temp;
            // consider the last item is sorted
            // only check heap properties in subarray [0:this.currentPosition - i - 1]
            this.fixDown(0, this.currentPosition - i - 1);

        }
    }

    private void fixDown(int index, int upto) {
        /**
         * restore the heap properties in the range of subarray index to upto
         */
        if (upto < 0) {
            upto = this.currentPosition;
        }
        while (index < upto) {
        	// find the pointer of the left/right child
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            // check if the child is still in range.
            if (leftChild < upto) {
                int childToSwap;
                if (rightChild > upto) {
                	// if right child out of range then only look at left child
                    childToSwap = leftChild;
                } else {
                	// if both of them are good, swap the larger one.
                    childToSwap = (this.heap[leftChild] > this.heap[rightChild])
                            ? leftChild
                            : rightChild;
                }
                // check if the heap properties hold
                // the left subtree is assumed all right so if no violation, we will break the loop
                if (this.heap[index] < this.heap[childToSwap]) {
                    int temp = this.heap[childToSwap];
                    // if not hold just swap them
                    this.heap[childToSwap] = this.heap[index];
                    this.heap[index] = temp;
                    index = childToSwap;
                } else {
                    break;
                }
            } else {
            	// if left child is already out of range, no worry about the heap properties
                break;
            }
        }
    }

    private boolean isFull() {
        // TODO Auto-generated method stub
        return this.currentPosition == this.heap.length;
    }
}
