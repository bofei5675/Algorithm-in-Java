package TwoSum;

import java.util.HashMap;

public class Solution {
    public void display() {
        System.out.println("Hello");
    }

    public int[] twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> dict = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < arr.length; i++) {
            int num1 = arr[i];
            if (!dict.containsKey(num1)) {
                dict.put(num1, i);
            }
            int num2 = target - num1;
            if (dict.containsKey(num2)) {
                result[0] = dict.get(num1);
                result[1] = dict.get(num2);
                return result;
            }

        }
        return result;
    }
}
