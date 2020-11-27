import java.util.*;
/*
 * @lc app=leetcode id=299 lang=java
 *
 * [299] Bulls and Cows
 */

// @lc code=start
class Solution {
  public String getHint(String secret, String guess) {
    int[] counts = new int[10];
    int bull = 0;
    int cow = 0;
    for (int i = 0; i < secret.length(); i++) {
      int s = secret.charAt(i) - '0';
      int g = guess.charAt(i) - '0';
      if (s == g) {
        bull++;
        continue;
      }
      if (counts[g] < 0) {
        cow++;
      }
      if (counts[s] > 0) {
        cow++;
      }
      counts[s]--;
      counts[g]++;
    }
    return String.valueOf(bull)+"A"+String.valueOf(cow)+"B";
  }
}
// @lc code=end
