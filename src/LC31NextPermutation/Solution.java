package LC31NextPermutation;

class Solution {
	/**
	 * 1) find the first two numbers (first,second) with increasing order starting from end of array
	 * 2) find the first element that is greater than first 
	 * 3) Exchange the element with first
	 * 4) Reverse the order of subarray[second:end]
	 * @param nums
	 */
    public void nextPermutation(int[] nums) {
        // find the first and second elements that are increasing order
        int i = nums.length - 1;
        
        for(;i >=1; i --){
            if(nums[i] > nums[i - 1]) break;
        }
        // find the first two elements that are in increasing order
        // exchange the first element as the following
        if(i != 0){
            int j = nums.length - 1;
            while(j > i){
                if(nums[j] > nums[i - 1]){
                    swap(nums,i - 1, j);
                }
                j --;
            }
        }
        
        // then reverse the subarray starting from j;
        reverse(nums,i);
        return ;
    }
    
    public void reverse(int[] nums,int i){
        int j = nums.length - 1;
        
        while(i < j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void display(int[] nums) {
    	for(int i : nums) {
    		System.out.print(i);
    		System.out.print(" ");
    	}
    	System.out.println("");
    }
}