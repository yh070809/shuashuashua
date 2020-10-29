146. LRU Cache
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
Follow up:
Could you do get and put in O(1) time complexity?

 

Example 1:

Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4
 

Constraints:

1 <= capacity <= 3000
0 <= key <= 3000
0 <= value <= 104
At most 3 * 104 calls will be made to get and put.


class LRUCache {
    class Node {
        int key, value;
        Node pre, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            pre = this;
            next = this;
        }
    }
   private final int capacity;// LRU Cache的容量
    private Node dummy;// dummy节点是一个冗余节点，dummy的next是链表的第一个节点，dummy的pre是链表的最后一个节点
    private Map<Integer, Node> cache;//保存key-Node对，Node是双向链表节点

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummy = new Node(0, 0);
        cache = new ConcurrentHashMap<>();
    }
  public int get(int key) {
        Node node = cache.get(key);
        if (node == null) return -1;
        remove(node);
        add(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            if (cache.size() >= capacity) {
                cache.remove(dummy.next.key);
                remove(dummy.next);
            }
            node = new Node(key, value);
            cache.put(key, node);
            add(node);
        } else {
            cache.remove(node.key);
            remove(node);
            node = new Node(key, value);
            cache.put(key, node);
            add(node);
        }
    }
    
   private void add(Node node) {
        dummy.pre.next = node;
        node.pre = dummy.pre;
        node.next = dummy;
        dummy.pre = node;
    }

    /**
     * 从双向链表中删除该节点
     *
     * @param node 要删除的节点
     */
    private void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */