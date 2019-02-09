class MyHashMap {
    private int[] values = new int[1000000];
    /** Initialize your data structure here. */
    public MyHashMap() {
        for(int i=0;i<values.length;i++)
            values[i]=-1;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        values[key]=value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return values[key];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        values[key]=-1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
