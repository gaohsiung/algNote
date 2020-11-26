import java.util.*;
/*
 * @lc app=leetcode id=1423 lang=java
 *
 * [1423] Maximum Points You Can Obtain from Cards
 */

// @lc code=start
class Solution {
  public int maxScore(int[] cardPoints, int k) {
    int sum = 0;
    for (int n: cardPoints) {
      sum += n;
    }
    if (k >= cardPoints.length) {
      return sum;
    }
    int left = 0;
    int right = cardPoints.length - k;
    int curSum = 0;
    for (int i = 0; i < cardPoints.length - k; i++) {
      curSum += cardPoints[i];
    }
    int globalMin = curSum;
    while (right < cardPoints.length) {
      curSum -= cardPoints[left++];
      curSum += cardPoints[right++];
      globalMin = Math.min(globalMin, curSum);
    }
    return sum - globalMin;
  }

}
// @lc code=end
