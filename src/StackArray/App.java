package StackArray;

public class App {
    public static void main(String[] args) {
        Stack<Integer> mystack = new Stack<>();

        mystack.push(10);
        mystack.push(100);
        mystack.push(1000);
        mystack.showContent();
        System.out.println(mystack.size());
        System.out.println(mystack.pop());
        System.out.println(mystack.size());

    }
}
