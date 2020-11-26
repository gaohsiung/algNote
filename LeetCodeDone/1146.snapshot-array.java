import java.util.*;
/*
 * @lc app=leetcode id=1146 lang=java
 *
 * [1146] Snapshot Array
 */

// @lc code=start
class SnapshotArray {
  private int curSnapId;
  private List<TreeMap<Integer, Integer>> snapArray;
  public SnapshotArray(int length) {
    this.curSnapId = 0;
    this.snapArray = new ArrayList<>(length);
    for (int i = 0; i < length; i++) {
      this.snapArray.add(null);
    }
  }
  public void set(int index, int val) {
    if (this.snapArray.get(index) == null) {
      this.snapArray.set(index, new TreeMap<Integer, Integer>());
      this.snapArray.get(index).put(0, 0);
    }
    this.snapArray.get(index).put(this.curSnapId, val);
  }

  public int snap() {
    this.curSnapId++;
    return this.curSnapId - 1;
  }

  public int get(int index, int snap_id) {
    if (this.snapArray.get(index) == null) {
      this.snapArray.set(index, new TreeMap<Integer, Integer>());
      this.snapArray.get(index).put(0, 0);
    }
    return this.snapArray.get(index).floorEntry(snap_id).getValue();

  }
  public static void main(String[] args) {
    SnapshotArray sArray = new SnapshotArray(3);
    sArray.set(0,5);
    sArray.snap();
    sArray.set(0,6);
    sArray.get(0,0);
  }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length); obj.set(index,val); int
 * param_2 = obj.snap(); int param_3 = obj.get(index,snap_id);
 */
// @lc code=end
