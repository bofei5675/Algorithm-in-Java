package MyCircularQueue;

public class APP {
    public static void main(String[] args) {
        MyCircularQueue mcq = new MyCircularQueue(3);
        System.out.println(mcq.isEmpty());
        mcq.enQueue(1);
        mcq.enQueue(2);
        mcq.enQueue(3);

        System.out.println(mcq.isFull());
        System.out.println(mcq);
        mcq.deQueue();
        mcq.enQueue(4);
        System.out.println(mcq);

        System.out.println(mcq.isEmpty());
        System.out.println(mcq.isFull());
    }
}
