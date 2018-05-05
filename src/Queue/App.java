package Queue;

public class App {
    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
        q.enqueue(1);
        q.enqueue(4);
        q.enqueue(6);
        q.enqueue(7);
        System.out.println(q.size());
        System.out.println(q.dequeue());
    }
}
