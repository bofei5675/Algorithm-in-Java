package Permutation;

import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static ArrayList<String> permutations(String words) {
        /*
         * Get all possible permutation from words
         *
         * @param words String input
         *
         * @return ArrayList<String> all combinations
         */
        ArrayList<String> result = new ArrayList<String>();
        permutations("", words, result);
        return result;

    }

    private static void permutations(String prefix, String suffix,
            ArrayList<String> result) {
        if (suffix.length() == 0) {
            result.add(prefix);
        } else {
            for (int i = 0; i < suffix.length(); i++) {
                permutations(prefix + suffix.charAt(i),
                        suffix.substring(0, i)
                                + suffix.substring(i + 1, suffix.length()),
                        result);

            }
        }
    }

    public static ArrayList<int[]> permutations(int[] n) {
        ArrayList<int[]> result = new ArrayList<int[]>();

        permutations(n, 0, result);

        return result;
    }

    private static void permutations(int[] prefix, int start,
            ArrayList<int[]> result) {
        if (start >= prefix.length) {
            result.add(Arrays.copyOf(prefix, prefix.length));
        } else {
            for (int i = start; i < prefix.length; i++) {
                // swap each position to get all possible value at start
                swap(prefix, start, i);
                permutations(prefix, start + 1, result);
                // then swap back so we don't modify the array
                swap(prefix, start, i);

            }
        }
    }

    private static void swap(int[] n, int i, int j) {
        int temp = n[i];
        n[i] = n[j];
        n[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        ArrayList<Integer> arr2 = new ArrayList<Integer>();
        arr2.add(1);
        arr2.add(2);
        arr2.add(3);
        String input = "abc";
        ArrayList<String> result = permutations(input);
        System.out.println(result);
        ArrayList<int[]> result1 = permutations(arr);
        for (int i = 0; i < result1.size(); i++) {
            int[] temp = result1.get(i);
            for (int j = 0; j < temp.length; j++) {
                System.out.print(temp[j]);
            }
            System.out.println("");
        }
    }
}
