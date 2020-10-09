import java.util.*;
/*
 * @lc app=leetcode id=703 lang=java
 *
 * [703] Kth Largest Element in a Stream
 */

// @lc code=start
class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int topK;
    public KthLargest(int k, int[] nums) {
        this.minHeap = new PriorityQueue<>();
        this.topK = k;
        for (int n: nums) {
            if (minHeap.size() < k) {
                minHeap.offer(n);
            } else {
                if (minHeap.peek() < n) {
                    minHeap.poll();
                    minHeap.offer(n);
                }
            }
        }
    }
    
    public int add(int val) {
        if (minHeap.size() < this.topK) {
            minHeap.offer(val);
        } else {
            if (minHeap.peek() < val) {
                minHeap.poll();
                minHeap.offer(val);
            }
        }
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
// @lc code=end

