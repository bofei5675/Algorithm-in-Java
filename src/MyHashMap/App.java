package MyHashMap;

public class App {
    public static void main(String[] args) {
        HashTable ht = new HashTable();
        ht.put(1, 10);
        ht.put(1, 100);
        ht.put(3, 1000);
        ht.put(4, 10000);
        System.out.println(ht.get(1));
    }
}
