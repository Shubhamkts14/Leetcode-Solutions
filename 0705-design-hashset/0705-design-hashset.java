import java.util.LinkedList;

class MyHashSet {
    private final int capacity = 1000;
    private LinkedList<Integer>[] buckets;

    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets = new LinkedList[capacity];
    }
    
    private int hashFunction(int key) {
        return key % capacity;
    }
    
    public void add(int key) {
        int index = hashFunction(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        LinkedList<Integer> bucket = buckets[index];
        if (!bucket.contains(key)) {
            bucket.add(key);
        }
    }
    
    public void remove(int key) {
        int index = hashFunction(key);
        LinkedList<Integer> bucket = buckets[index];
        if (bucket != null) {
            bucket.remove(Integer.valueOf(key));
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = hashFunction(key);
        LinkedList<Integer> bucket = buckets[index];
        return bucket != null && bucket.contains(key);
    }
}
