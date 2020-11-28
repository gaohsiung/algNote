/*
 * @lc app=leetcode id=157 lang=java
 *
 * [157] Read N Characters Given Read4
 */

// @lc code=start
/**
 * The read4 API is defined in the parent class Reader4. int read4(char[] buf4);
 */

public class Solution extends Reader4 {
  /**
   * @param buf Destination buffer
   * @param n   Number of characters to read
   * @return The number of actual characters read
   */
  public int read(char[] buf, int n) {
    char[] tempBuf = new char[4];
    int total = 0;
    int tempCount = -1;
    while (total < n && tempCount != 0) {
      tempCount = read4(tempBuf);
      for (int i = total; i < total+tempCount && i < n; i++) {
        buf[i] = tempBuf[i - total];

      }
      total = Math.min(n, total+tempCount);
    }
    return total;
  }
}
// @lc code=end
