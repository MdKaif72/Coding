package dsa.blind75Question.simple;
/*
LC 146
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the
cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.



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
0 <= key <= 104
0 <= value <= 105
At most 2 * 105 calls will be made to get and put.
 */

import java.util.HashMap;
import java.util.Map;

class DoublyLL {
    DoublyLL prev;
    DoublyLL next;
    int key;
    int val;

    public DoublyLL(DoublyLL prev, DoublyLL next, int key, int val) {
        this.prev = prev;
        this.next = next;
        this.val = val;
        this.key = key;
    }
}

public class LRUCache {

    DoublyLL head;
    DoublyLL tail;
    Map<Integer, DoublyLL> map;
    private int maxCapacity;

    public LRUCache(int capacity) {

        this.head = new DoublyLL(null, null, -1, -1);
        this.tail = new DoublyLL(head, null, -1, -1);
        this.maxCapacity = capacity;
        map = new HashMap<>();
        this.head.next=tail;
    }

    public int get(int key) {

        if (!map.containsKey(key))
            return -1;
        DoublyLL node = map.get(key);
        deleteNode(node);
        updateToHead(node);
        return node.val;

    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DoublyLL node = map.get(key);
            node.val = value;
            deleteNode(node);
            updateToHead(node);
        } else {
            if (maxCapacity == map.size()) {//If capacity is full delete the tail prev
                map.remove(tail.prev.key);
                deleteNode(tail.prev);

            }
            DoublyLL newNode = new DoublyLL(null, null, key, value);
            updateToHead(newNode);
            map.put(key, newNode);

        }

    }

    private void deleteNode(DoublyLL node) {
        DoublyLL prevNode = node.prev;
        DoublyLL nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void updateToHead(DoublyLL node) {

        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }


}
