/*
 * @lc app=leetcode id=158 lang=java
 *
 * [158] Read N Characters Given Read4 II - Call multiple times
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
  private int read4Count = 0;
  private int read4Pointer = 0;
  private char[] read4buf = new char[4];
  public int read(char[] buf, int n) {
    int readPointer = 0;
    while (readPointer < n) {
      if (read4Pointer == 0) {
        read4Count = read4(read4buf);
      }
      if (read4Count == 0) {
        break;
      }
      while (readPointer < n && read4Pointer < read4Count) {
        buf[readPointer++] = read4buf[read4Pointer++];
      }
      if (readPointer < n) {
        read4Pointer = 0;
      }
    }
    return readPointer;
  }
}
// @lc code=end
