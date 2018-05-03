package LinkedList;

public class App {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<Integer>();

        list.insert(1);
        list.insert(3);
        list.insert(5);
        list.insert(4);
        list.insert(2);
        System.out.println(list.size());
        list.remove(7);
        System.out.println(list.size());
        list.transverse();
    }
}
