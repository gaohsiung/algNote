import java.util.*;
/*
 * @lc app=leetcode id=1281 lang=java
 *
 * [1281] Subtract the Product and Sum of Digits of an Integer
 */

// @lc code=start
class Solution {
  public int subtractProductAndSum(int n) {
    List<Integer> digits = new ArrayList<>();
    while (n != 0) {
      digits.add(n%10);
      n /= 10;
    }
    int sum = 0;
    int product = 1;
    for (int digit: digits) {
      sum += digit;
      product *= digit;
    }
    return product - sum;
  }
}
// @lc code=end
