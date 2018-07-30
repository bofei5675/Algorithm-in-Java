package BinaryIndexTree;

public class APP {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3, 4, 5 };
        BinaryIndexTree bit = new BinaryIndexTree(nums);
        bit.display();
        System.out.println(bit.getSum(0, 5));
    }

}
