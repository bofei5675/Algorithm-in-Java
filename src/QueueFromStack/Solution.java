package QueueFromStack;

public class Solution {
    public static void main(String[] args) {
        MyQueue q = new MyQueue();

        q.push(1);
        q.display();
        q.push(2);
        q.display();
        q.push(3);
        q.display();
        q.push(4);
        q.display();
        q.push(5);
        System.out.println(q.pop());
        q.display();
        System.out.println(q.pop());
        q.display();
        System.out.println(q.pop());
        q.display();
        System.out.println(q.pop());
        q.display();

    }
}
