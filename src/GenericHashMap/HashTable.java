package GenericHashMap;

public class HashTable<Key, Value> {
    private Key[] key;
    private Value[] value;
    private int numOfItems;
    private int capacity;

    /*
     * Key and Value have the same index order
     */
    public HashTable(int capacity) {
        this.key = (Key[]) new Object[Constants.TABLE_SIZE];
        this.value = (Value[]) new Object[Constants.TABLE_SIZE];
        this.capacity = capacity;
        this.numOfItems = 0;
    }

    public HashTable() {
        this.key = (Key[]) new Object[Constants.TABLE_SIZE];
        this.value = (Value[]) new Object[Constants.TABLE_SIZE];
        this.capacity = Constants.TABLE_SIZE;
        this.numOfItems = 0;
    }

    public int size() {
        return this.numOfItems;
    }

    public boolean isEmpty() {
        return this.numOfItems == 0;
    }

    public void remove(Key key) {
        if (key == null) {
            return;
        }
        int index = this.hash(key);
        while (!this.key[index].equals(key)) {

            index = (index + 1) % this.capacity;
        }
        this.key[index] = null;
        this.value[index] = null;
        this.numOfItems--;
        // make sure the same cluster will not have empty spots in between
        while (this.key[index] != null) {
            Key tempKey = this.key[index];
            Value tempValue = this.value[index];

            this.key[index] = null;
            this.value[index] = null;
            this.numOfItems--;
            this.put(tempKey, tempValue);
            index = (index + 1) % this.capacity;

        }
        // resize if the size is too large
        // reduce memory space
        if (this.numOfItems < this.capacity / 3) {
            this.resize(this.capacity / 2);
        }

    }

    public void put(Key key, Value value) {
        if (key == null || value == null) {
            return;
        }
        // in Java, resize table if get 75% full
        if (this.numOfItems >= this.capacity * 0.75) {
            // minimize numbers of collision ;
            this.resize(2 * this.capacity);
        }
        // after resize, we do insertion
        int index = this.hash(key);
        while (this.key[index] != null) {
            // update if table has the same key
            if (this.key[index].equals(key)) {
                this.value[index] = value;
            }
            index = (index + 1) % this.capacity;

        }
        this.key[index] = key;
        this.value[index] = value;
    }

    // O(N) have to minimize the number of resize operation ...
    private void resize(int i) {
        // TODO Auto-generated method stub
        // make a new hashtable with a different size
        HashTable<Key, Value> newHashtable = new HashTable<>(i);
        for (int j = 0; j < i; j++) {
            newHashtable.put(this.key[j], this.value[j]);

        }
        // update this hashTable
        this.key = newHashtable.getKey();
        this.value = newHashtable.getValue();
        this.setCapacity(i);
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Key[] getKey() {
        return this.key;
    }

    public void setKey(Key[] key) {
        this.key = key;
    }

    public Value[] getValue() {
        return this.value;
    }

    public void setValue(Value[] value) {
        this.value = value;
    }

    public Value get(Key givenKey) {
        if (givenKey == null) {
            return null;
        }

        int valueIndex = this.hash(givenKey);
        while (this.key[valueIndex] != null) {
            if (this.key[valueIndex].equals(givenKey)) {
                return this.value[valueIndex];
            }
            // linear probing so we move to next items;
            valueIndex = (valueIndex + 1) % this.capacity;
        }
        // if not found for the given Key
        System.out.println("Given Key is not found");
        return null;

    }

    private int hash(Key key) {
        // hashcode is the built-in func in Java
        // to sort of convert an object to int
        return key.hashCode() % this.capacity;
    }
}
