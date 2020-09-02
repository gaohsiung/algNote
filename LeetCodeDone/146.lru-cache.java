import java.util.*;


/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start
class LRUCache {
    MyNode head;
    MyNode tail;
    int capacity;
    int curSize;
    Map<Integer, MyNode> keyToNodeMap;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        curSize = 0;
        this.head = new MyNode(0,0);
        this.tail = new MyNode(0,0);
        this.head.next = tail;
        this.tail.prev = head;
        this.keyToNodeMap = new HashMap<>();
    }
    
    public int get(int key) {
        if (!keyToNodeMap.containsKey(key)) {
            return -1; // TODO: throw illegal argument exceptions
        }
        MyNode cur = keyToNodeMap.get(key);
        moveToHead(cur);
        return cur.val;
    }
    
    private void moveToHead(MyNode cur) {
        MyNode prevCur = cur.prev;
        MyNode nextCur = cur.next;
        prevCur.next = nextCur;
        nextCur.prev = prevCur;

        cur.next = this.head.next;
        this.head.next.prev = cur;
        cur.prev = this.head;
        this.head.next = cur;
    }

    public void put(int key, int value) {
        if (keyToNodeMap.containsKey(key)) {
            MyNode cur = keyToNodeMap.get(key);
            cur.val = value;
            moveToHead(cur);
            return;
        }
        MyNode newNode = new MyNode(key, value);
        keyToNodeMap.put(key, newNode);
        if (this.curSize >= this.capacity) {
            // remove last one
            keyToNodeMap.remove(this.tail.prev.key);
            this.tail.prev.prev.next = this.tail;
            this.tail.prev = this.tail.prev.prev;
            this.curSize--;
        }
        newNode.next = this.head.next;
        this.head.next.prev = newNode;
        newNode.prev = this.head;
        this.head.next = newNode;
        this.curSize++;
    }
}
class MyNode{
    int key;
    int val;
    MyNode prev;
    MyNode next;

    MyNode(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

