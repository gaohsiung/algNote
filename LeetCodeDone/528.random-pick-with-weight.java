import java.util.*;
/*
 * @lc app=leetcode id=528 lang=java
 *
 * [528] Random Pick with Weight
 */

// @lc code=start
class Solution {
  TreeMap<Integer, Integer> bstMap;
  int range;
  public Solution(int[] w) {
    this.bstMap = new TreeMap<>();
    int sum = 0;
    for (int i = 0; i < w.length; i++) {
      if (w[i] <= 0) {
        throw new IllegalArgumentException();
      }
      sum += w[i];
      bstMap.put(sum, i);
    }
    this.range = sum;
  }

  public int pickIndex() {
    Random rand = new Random();
    int cur = rand.nextInt(this.range) + 1;
    return this.bstMap.ceilingEntry(cur).getValue();
  }
}

/**
 * Your Solution object will be instantiated and called as such: Solution obj =
 * new Solution(w); int param_1 = obj.pickIndex();
 */
// @lc code=end
/*
class Solution {
  private int[] prefixSum;
  public Solution(int[] w) {
    this.prefixSum = new int[w.length];
    for (int i = 0; i < w.length; i++) {
      if (i == 0) {
        this.prefixSum[i] = w[i];
        continue;
      }
      this.prefixSum[i] = this.prefixSum[i-1] + w[i];
    }
  }

  public int pickIndex() {
    Random randgenerator = new Random();
    int target = randgenerator.nextInt(this.prefixSum[this.prefixSum.length - 1]);
    int left = 0;
    int right = this.prefixSum.length - 1;
    int mid;
    while (left <= right) {
      mid = left + (right - left) / 2;
      if (this.prefixSum[mid] == target) {
        return mid + 1;
      }
      if (this.prefixSum[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return left;

  }
  public static void main(String[] args) {
    Solution sol = new Solution(new int[]{1,3});
    for (int i = 0; i< 10; i++){
      System.out.println(sol.pickIndex());
    }
  }
}
*/