import java.util.*;
/*
 * @lc app=leetcode id=359 lang=java
 *
 * [359] Logger Rate Limiter
 */

// @lc code=start
class Logger {

  /** Initialize your data structure here. */
  Map<String, Integer> logToLastPrintTimeStamp;

  public Logger() {
    this.logToLastPrintTimeStamp = new HashMap<>();
  }

  /**
   * Returns true if the message should be printed in the given timestamp,
   * otherwise returns false. If this method returns false, the message will not
   * be printed. The timestamp is in seconds granularity.
   */
  public boolean shouldPrintMessage(int timestamp, String message) {
    if (!this.logToLastPrintTimeStamp.containsKey(message)) {
      this.logToLastPrintTimeStamp.put(message, timestamp);
      return true;
    }
    if (timestamp - this.logToLastPrintTimeStamp.get(message) >= 10) {
      this.logToLastPrintTimeStamp.put(message, timestamp);
      return true;
    }
    return false;
  }
}

/**
 * Your Logger object will be instantiated and called as such: Logger obj = new
 * Logger(); boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
// @lc code=end
