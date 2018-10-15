package RedBlackTree;

public class App {
    public static void main(String[] args) {
        Tree<Integer> rbt = new RedBlackTree<Integer>();
        rbt.insert(1);
        rbt.showRootColor();
        rbt.insert(2);
        rbt.showRootColor();
        rbt.insert(3);
        rbt.showRootColor();
        rbt.insert(4);
        rbt.insert(5);
        rbt.traverse();
    }
}
