package BinaryIndexTree;

import java.util.Arrays;

public class BinaryIndexTree {
    private int[] BITree;
    private int[] arr;
    private int size;

    public BinaryIndexTree(int[] nums) {
        super();
        // initialized tree by the n + 1 length
        this.BITree = new int[nums.length + 1];
        this.arr = nums;

        this.size = this.arr.length;
        Arrays.fill(this.BITree, 0);
        for (int i = 0; i < this.size; i++) {
            this.updateTree(i, nums[i]);
        }
    }

    public void display() {
        for (int i = 0; i < this.BITree.length; i++) {
            System.out.println(this.BITree[i]);
        }
    }

    public void updateTree(int i, int val) {
        i = i + 1; // start from 1
        while (i <= this.size) {
            // add parent sum into children
            this.BITree[i] += val;
            //System.out.println(i);
            //System.out.println((i & (-i)));
            i += (i & (-i));
        }
        //System.out.println();
    }

    public int getSum(int start, int end) {
        int sum = 0;
        while (end > start) {
            sum += this.BITree[end];
            end -= (end & (-end));
        }

        return sum;
    }

    public int[] getBITree() {
        return this.BITree;
    }

    public void setBITree(int[] bITree) {
        this.BITree = bITree;
    }

}
