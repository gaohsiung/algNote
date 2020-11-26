import java.util.*;
/*
 * @lc app=leetcode id=946 lang=java
 *
 * [946] Validate Stack Sequences
 */

// @lc code=start
class Solution {
  public boolean validateStackSequences(int[] pushed, int[] popped) {
    // c.c.

    Stack<Integer> stack = new Stack<>();
    int pushPointer = 0;
    int popPointer = 0;
    int n = pushed.length;
    while(popPointer < n) {
      int curPop = popped[popPointer];
      if (!stack.isEmpty() && stack.peek() == curPop) {
        stack.pop();
        popPointer++;
        continue;
      }
      while(pushPointer < n && (stack.isEmpty() || stack.peek() != curPop)) {
        stack.push(pushed[pushPointer++]);
      }
      if (pushPointer == n && (stack.isEmpty() || stack.peek() != curPop)) {
        return false;
      }
    }
    return true;

  }
}
// @lc code=end
