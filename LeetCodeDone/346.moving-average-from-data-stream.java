import java.util.*;
/*
 * @lc app=leetcode id=346 lang=java
 *
 * [346] Moving Average from Data Stream
 */

// @lc code=start
class MovingAverage {

  /** Initialize your data structure here. */
  private int totalSize;
  private int curSize;
  private int sum;
  private Queue<Integer> slidingQueue;
  public MovingAverage(int size) {
    this.totalSize = size;
    this.curSize = 0;
    this.slidingQueue = new LinkedList<>();
  }

  public double next(int val) {
    if (curSize < totalSize) {
      curSize++;
    } else {
      this.sum = this.sum - this.slidingQueue.poll();
    }
    this.slidingQueue.offer(val);
    this.sum += val;
    return (double) this.sum / (double) this.curSize;
  }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size); double param_1 = obj.next(val);
 */
// @lc code=end
