import java.util.*;
/*
 * @lc app=leetcode id=981 lang=java
 *
 * [981] Time Based Key-Value Store
 */

// @lc code=start
class TimeMap {

  /** Initialize your data structure here. */
  Map<String, TreeMap<Integer, String>> timeBasedKeyValMap;
  public TimeMap() {
    timeBasedKeyValMap = new HashMap<>();
  }

  public void set(String key, String value, int timestamp) {
    if (!this.timeBasedKeyValMap.containsKey(key)) {
      this.timeBasedKeyValMap.put(key, new TreeMap<>());
    }
    this.timeBasedKeyValMap.get(key).put(timestamp, value);
  }

  public String get(String key, int timestamp) {
    if (!this.timeBasedKeyValMap.containsKey(key)) {
      return "";
    }
    if (this.timeBasedKeyValMap.get(key).floorKey(timestamp) == null) {
      return "";
    }
    return this.timeBasedKeyValMap.get(key).floorEntry(timestamp).getValue();

  }
}

/**
 * Your TimeMap object will be instantiated and called as such: TimeMap obj =
 * new TimeMap(); obj.set(key,value,timestamp); String param_2 =
 * obj.get(key,timestamp);
 */
// @lc code=end
