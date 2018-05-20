package Heap;

public class App {
    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.insert(10);
        heap.insert(20);
        heap.insert(30);
        heap.insert(15);
        heap.insert(6);
        heap.insert(1);
        heap.heapsort();

        System.out.println(heap.getMax());
        System.out.println(heap.getMax());
        System.out.println(heap.getMax());
        System.out.println(heap.getMax());

    }

}
