package AddTwoNumbers;

public class Solution {
    public MyLinkedList addTwoNumbers(MyLinkedList arr1, MyLinkedList arr2) {
        MyLinkedList<Integer> result = new MyLinkedList<>();
        Node r1 = arr1.getRoot();
        Node r2 = arr2.getRoot();
        int incre = 0;
        while (r1 != null || r2 != null) {

            int data1 = (r1 != null) ? (int) r1.getData() : 0;
            int data2 = (r2 != null) ? (int) r2.getData() : 0;
            int data3 = (data1 + data2);
            if (data3 > 10) {
                data3 = data3 % 10;
                result.insert(data3 + incre);
                incre = 1;
            } else {
                result.insert(data3 + incre);
                incre = 0;
            }
            r1 = (r1 != null) ? r1.getNext() : null;
            r2 = (r2 != null) ? r2.getNext() : null;
            if (r1 == null && r2 == null && incre == 1) {
                result.insert(incre);
            }
        }
        return result;
    }

    private Node addTwoNumbers(Node r1, Node r2) {
        // TODO Auto-generated method stub
        return null;
    }
}
