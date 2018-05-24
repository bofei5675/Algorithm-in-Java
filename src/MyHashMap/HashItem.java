package MyHashMap;

public class HashItem {
    private int key;
    private int value;
    private HashItem nextItem;

    public HashItem(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return this.key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public HashItem getNextItem() {
        return this.nextItem;
    }

    public void setNextItem(HashItem nextItem) {
        this.nextItem = nextItem;
    }

}
