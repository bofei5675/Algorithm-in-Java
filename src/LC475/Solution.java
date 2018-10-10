package LC475;

import java.util.Arrays;
/**
 * Leetcode 475 find smallest radius based on position of house 
 * and heater.
 * Two ways
 * 1) Binary Tree Search
 * 2) Two pointer.
 * @author bofeizhang
 *
 */
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int res = Integer.MIN_VALUE;
        for(int house: houses){
            int index = Arrays.binarySearch(heaters, house);
            if(index < 0){
                index = -(index + 1);
            }
            
            int left = index > 0 ? house - heaters[index - 1]: Integer.MAX_VALUE;
            int right = index < heaters.length ? heaters[index] - house: Integer.MAX_VALUE;
            
            res = Math.max(res, Math.min(left,right));
            
        }
        return res;
    }
}