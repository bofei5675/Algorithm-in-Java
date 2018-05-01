package Arrays;

/**
 * Simple HelloWorld program (clear of Checkstyle and FindBugs warnings).
 *
 * @author P. Bucci
 */
public class App {

    public static void main(String[] args) {
        int[] nums = new int[5];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }
        /*
         * Linear search O(N) Binary tree search O(logN) Hashtable search O(1)
         */
        System.out.println(nums[2]);
        System.out.println("Hello World!!!");
    }

}
