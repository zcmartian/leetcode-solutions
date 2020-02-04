/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 *
 * https://leetcode.com/problems/lru-cache/description/
 *
 * algorithms
 * Hard (23.92%)
 * Total Accepted:    260.6K
 * Total Submissions: 1.1M
 * Testcase Example:  '["LRUCache","put","put","get","put","get","put","get","get","get"]\n[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]'
 *
 * 
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.
 * 
 * 
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently
 * used item before inserting a new item.
 * 
 * 
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * 
 * Example:
 * 
 * LRUCache cache = new LRUCache( 2 capacity);
 * 
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 * 
 * 
 */
class LRUCache {
    private LinkedHashMap<Integer, Integer> cache;
    private int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<>(capacity);
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        moveToEnd(key);
        return cache.get(key);
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key))
            moveToEnd(key);
        cache.put(key, value);
        if(cache.size()>capacity)
            removeFirst();
    }

    private void moveToEnd(int key) {
        int value = cache.get(key);
        cache.remove(key);
        cache.put(key, value);
    }

    private void removeFirst() {
        cache.remove(cache.entrySet().iterator().next().getKey());
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
