import java.util.*;
/*
 * @lc app=leetcode id=706 lang=java
 *
 * [706] Design HashMap
 */

// @lc code=start
class MyHashMap {

  /** Initialize your data structure here. */
  private static class Cell {
    private int key;
    private int val;

    private Cell(int key, int val) {
      this.key = key;
      this.val = val;
    }
    private int getKey(){
      return this.key;
    }
    private int getVal(){
      return this.val;
    }
    private void setKey(int key) {
      this.key = key;
    }
    private void setVal(int val) {
      this.val = val;
    }
    @Override
    public int hashCode() {
      return key;
    }
    @Override 
    public boolean equals(Object o) {
      if (o == null) {
        return false;
      }
      if (!(o instanceof Cell)) {
        return false;
      }
      Cell that = (Cell) o;
      return this.getKey() == that.getKey();
    }
  }
  private List<Cell>[] buckets;
  private int size;
  private int capacity;

  private static final int DEFAULT_CAPACITY = 256;
  public MyHashMap() {
    this.buckets = new List[DEFAULT_CAPACITY];
    this.size = 0;
    this.capacity = DEFAULT_CAPACITY;
  }

  private int getHashCode(Cell cell) {
    return Math.abs(cell.hashCode() % this.capacity);
  }

  /** value will always be non-negative. */
  public void put(int key, int value) {
    Cell newCell = new Cell(key, value);
    int idx = getHashCode(newCell);
    if (this.buckets[idx] == null) {
      this.buckets[idx] = new ArrayList<>();
    }
    for (Cell c: this.buckets[idx]) {
      if (c.equals(newCell)) {
        c.setVal(value);
        return;
      }
    }
    this.buckets[idx].add(newCell);
    this.size++;
  }

  /**
   * Returns the value to which the specified key is mapped, or -1 if this map
   * contains no mapping for the key
   */
  public int get(int key) {
    Cell readCell = new Cell(key, 0);
    int idx = getHashCode(readCell);
    if (this.buckets[idx] == null) {
      return -1;
    }
    for (Cell c: this.buckets[idx]) {
      if (c.equals(readCell)) {
        return c.getVal();
      }
    }
    return -1;
  }

  /**
   * Removes the mapping of the specified value key if this map contains a mapping
   * for the key
   */
  public void remove(int key) {
    Cell deleteCell = new Cell(key, 0);
    int idx = getHashCode(deleteCell);
    if (this.buckets[idx] == null) {
      return;
    }
    int removedIdx = -1;
    int bucketSize = this.buckets[idx].size();
    for (int i = 0; i < bucketSize; i++) {
      if (this.buckets[idx].get(i).equals(deleteCell)) {
        removedIdx = i;
      }
    }
    if (removedIdx == -1) {
      return;
    }
    this.buckets[idx].set(removedIdx, this.buckets[idx].get(bucketSize - 1));
    this.buckets[idx].remove(bucketSize - 1);
    this.size--;
    return;
  }
}

/**
 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj
 * = new MyHashMap(); obj.put(key,value); int param_2 = obj.get(key);
 * obj.remove(key);
 */
// @lc code=end
