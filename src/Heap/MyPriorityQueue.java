package Heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class MyPriorityQueue {
    public static void main(String[] args) {
        Queue<Person> q = new PriorityQueue<>();
        Person a = new Person("jack", 20);
        Person b = new Person("Joel", 35);
        q.add(new Person("jack", 20));
        q.add(new Person("jack2", 202));
        q.add(new Person("jack3", 203));
        q.add(new Person("jack4", 204));
        q.add(new Person("jack5", 205));
        System.out.println(a.compareTo(b));
        while (q.peek() != null) {
            System.out.println(q.poll());
        }
    }
}
