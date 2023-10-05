class MyHashMap {

    Integer[] arr;

    public MyHashMap() {
        arr = new Integer[512];
    }
    
    public void put(int key, int value) {
        if (key >= arr.length)
            resize(key);
        arr[key] = value;
    }
    
    public int get(int key) {
        if (key >= arr.length)
            return -1;

        Integer res = arr[key];
        return res != null ? res : -1;
    }
    
    public void remove(int key) {
        if (key < arr.length)
            arr[key] = null;
    }

    private void resize(int newSize) {
        Integer[] newArr = new Integer[newSize + 128];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        arr = newArr;
    }
}