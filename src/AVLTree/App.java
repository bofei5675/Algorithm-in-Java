package AVLTree;

public class App {
    public static void main(String[] args) {
        Tree tree = new AVLTree<Integer>();
        tree.insert(10);
        tree.insert(15);
        tree.insert(5);
        tree.insert(6);

        tree.delete(15);
        tree.traverse();
    }
}
