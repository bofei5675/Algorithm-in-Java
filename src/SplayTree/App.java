package SplayTree;

public class App {
    public static void main(String[] args) {
        Tree splay = new SplayTree<Integer>();
        splay.insert(10);
        splay.insert(20);
        splay.insert(30);
        splay.insert(40);
        splay.insert(50);
        splay.printRoot();
        splay.inOrderTranverse();
        System.out.print(splay.getMax());
        System.out.println(splay.find(20));
        splay.printRoot();
    }
}
