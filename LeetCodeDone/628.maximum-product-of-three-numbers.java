import java.util.*;

/*
 * @lc app=leetcode id=628 lang=java
 *
 * [628] Maximum Product of Three Numbers
 */

// @lc code=start
class Solution {
  public int maximumProduct(int[] nums) {
    PriorityQueue<Integer> negMaxHeap = new PriorityQueue<>(new Comparator<Integer>(){
      @Override
      public int compare(Integer i1, Integer i2) {
        return i2 - i1;
      }
    });
    PriorityQueue<Integer> posMinHeap = new PriorityQueue<>();

    for (int i: nums) {
      if (negMaxHeap.size() < 2) {
        negMaxHeap.offer(i);
      } else {
        if (negMaxHeap.peek() > i) {
          negMaxHeap.poll();
          negMaxHeap.offer(i);
        }
      }
      if (posMinHeap.size() < 3) {
        posMinHeap.offer(i);
      } else {
        if (posMinHeap.peek() < i) {
          posMinHeap.poll();
          posMinHeap.offer(i);
        }
      }
    }
    int max1 = posMinHeap.poll();
    int max2 = posMinHeap.poll();
    int max3 = posMinHeap.poll();
    int min1 = negMaxHeap.poll();
    int min2 = negMaxHeap.poll();
    return Math.max(max1*max2*max3, max3*min1*min2);
  }
}
// @lc code=end
