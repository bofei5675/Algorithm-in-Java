package TwoSum;

public class APP {
    public void solution() {
        System.out.println("Hello World");
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        int target = 7;
        int[] result = s.twoSum(arr, target);
        for (int each : result) {
            System.out.println(each);
        }

    }
}
