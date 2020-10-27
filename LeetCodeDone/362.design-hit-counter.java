import java.util.*;
/*
 * @lc app=leetcode id=362 lang=java
 *
 * [362] Design Hit Counter
 */

// @lc code=start
class HitCounter {

  /** Initialize your data structure here. */
  Queue<Integer> timeQueue;
  int period;
  public HitCounter() {
    this.timeQueue = new LinkedList<>();
    this.period = 300;
  }

  /**
   * Record a hit.
   * 
   * @param timestamp - The current timestamp (in seconds granularity).
   */
  public void hit(int timestamp) {
    if (timestamp <= this.period) {
      this.timeQueue.offer(timestamp);
      return;
    }
    updateQueue(timestamp);
    this.timeQueue.offer(timestamp);
  }

  /**
   * Return the number of hits in the past 5 minutes.
   * 
   * @param timestamp - The current timestamp (in seconds granularity).
   */
  public int getHits(int timestamp) {
    updateQueue(timestamp);
    return this.timeQueue.size();
  }
  private void updateQueue(int timestamp) {
    while (!this.timeQueue.isEmpty() && this.timeQueue.peek() <= timestamp - this.period) {
      this.timeQueue.poll();
    }
  }
  public static void main(String[] args) {
    HitCounter hc = new HitCounter();
    hc.hit(2);
    hc.hit(3);
    hc.hit(4);
    hc.getHits(300);
    hc.getHits(301);
    hc.getHits(302);
    hc.getHits(303);
    hc.getHits(304);
    hc.hit(501);
    hc.getHits(600);
  }
}

/**
 * Your HitCounter object will be instantiated and called as such: HitCounter
 * obj = new HitCounter(); obj.hit(timestamp); int param_2 =
 * obj.getHits(timestamp);
 */
// @lc code=end
