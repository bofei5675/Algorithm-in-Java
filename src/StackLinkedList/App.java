package StackLinkedList;

public class App {
    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<>();

        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);

        System.out.println(myStack.size());
        System.out.println(myStack.pop());
        System.out.println(myStack.size());
        System.out.println(myStack.peek());
    }
}
