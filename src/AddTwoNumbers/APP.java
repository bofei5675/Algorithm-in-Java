package AddTwoNumbers;

public class APP {
    public static void main(String[] args) {
        MyLinkedList<Integer> arr1 = new MyLinkedList<>();
        MyLinkedList<Integer> arr2 = new MyLinkedList<>();
        arr1.insert(1);
        arr2.insert(2);
        arr1.insert(4);
        arr2.insert(7);
        arr1.insert(8);

        arr1.display();
        arr2.display();

        Solution s = new Solution();
        MyLinkedList arr3 = s.addTwoNumbers(arr1, arr2);
        arr3.display();
    }
}
