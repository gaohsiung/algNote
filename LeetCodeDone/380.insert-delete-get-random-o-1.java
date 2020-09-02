import java.util.*;

/*
 * @lc app=leetcode id=380 lang=java
 *
 * [380] Insert Delete GetRandom O(1)
 */

// @lc code=start
class RandomizedSet {

    /** Initialize your data structure here. */
    private List<Integer> list;
    private Map<Integer, Integer> checkDups;
    private int size;
    public RandomizedSet() {
        this.list = new ArrayList<>();
        this.checkDups = new HashMap<>();
        this.size = 0;
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (checkDups.containsKey(val)) {
            return false;
        }
        if (this.list.size() == this.size) {
            this.list.add(val);
        } else {
            this.list.set(this.size, val);
        }
        checkDups.put(val, this.size);
        this.size++;
        return true;
        
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!checkDups.containsKey(val)) {
            return false;
        }
        checkDups.put(this.list.get(this.size - 1), this.checkDups.get(val)); // important! update map
        swap(this.list, this.checkDups.get(val), this.size - 1);
        checkDups.remove(val);
        this.size--;
        return true;
    }
    
    private void swap(List<Integer> list, int i1, int i2) {
        int temp = list.get(i1);
        list.set(i1, list.get(i2));
        list.set(i2, temp);
    }

    /** Get a random element from the set. */
    public int getRandom() {
        if (this.size == 0) throw new IllegalArgumentException();
        Random rand = new Random();
        int randomGetIndex = rand.nextInt(this.size);
        return this.list.get(randomGetIndex);
    }
    public static void main(String[] args) {
        RandomizedSet randSet = new RandomizedSet();
        randSet.insert(0);
        randSet.insert(1);
        randSet.remove(0);
        randSet.insert(2);
        randSet.remove(1);
        randSet.getRandom();
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
// @lc code=end

/*
["RandomizedSet","insert","insert","remove","insert","remove","getRandom"]
\n[[],[0],[1],[0],[2],[1],[]]
  */
