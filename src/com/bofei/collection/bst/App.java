package com.bofei.collection.bst;

public class App {
    public static void main(String[] args) {
        Tree<Integer> tree = new BST<>();
        tree.insert(1);
        tree.insert(10);
        tree.insert(7);
        tree.insert(4);
        tree.insert(8);
        tree.insert(16);
        tree.insert(9);
        System.out.println(tree.getMaxValue());
        System.out.println(tree.getMinValue());
        tree.travel();

        tree.delete(17);
        System.out.println(" ");
        tree.travel();
        System.out.println();
        Tree<Person> tree2 = new BST<>();
        tree2.insert(new Person("James", 21));
        tree2.insert(new Person("Joel", 22));
        tree2.insert(new Person("Anna", 23));
        tree2.insert(new Person("Ewy", 26));
        tree2.insert(new Person("Bofei", 41));
        tree2.travel();
    }
}
