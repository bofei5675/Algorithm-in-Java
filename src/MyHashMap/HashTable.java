package MyHashMap;

public class HashTable {
    // container
    private HashItem[] hashtable;

    // need a hash function to generate keys
    private int hash(int key) {
        return key % Constants.TABLE_SIZE;
    }

    // put method with O1 complexity
    public void put(int key, int value) {
        int hashIndex = this.hash(key);
        if (this.hashtable[hashIndex] == null) {
            this.hashtable[hashIndex] = new HashItem(key, value);
        } else {
            // find the last item in this slot
            // while loop in the original video

            HashItem lastItem = this.findLastItem(this.hashtable[hashIndex]);
            lastItem.setNextItem(new HashItem(key, value));
        }
        // not implemented the case that duplicated key is inserted
    }

    public int get(int key) {
        int arrayIndex = this.hash(key);
        HashItem target = this.hashtable[arrayIndex];
        while (target != null && target.getKey() != key) {
            target = target.getNextItem();
        }
        if (target == null) {
            throw new NullPointerException("Data not found.");
        }
        return target.getValue();
    }

    private HashItem findLastItem(HashItem hashItem) {
        // TODO Auto-generated method stub
        if (hashItem.getNextItem() != null) {
            return this.findLastItem(hashItem.getNextItem());
        }
        return hashItem;
    }
}
