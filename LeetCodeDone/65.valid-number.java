/*
 * @lc app=leetcode id=65 lang=java
 *
 * [65] Valid Number
 */

// @lc code=start
class Solution {
  /*
  Deterministic Finite Automation
       0     1    2    3     4       5
      0-9   +/-   e    .   blank   others
  S0   2     1   -1    3     0      -1   initial state _
  S1   2    -1   -1    3    -1      -1   +/- 
  S2   2    -1    5    4     8      -1   123                  (valid)
  S3   4    -1   -1   -1    -1      -1   .
  S4   4    -1    5   -1     8      -1   123.                 (valid)
  S5   7     6   -1   -1    -1      -1   123e
  S6   7    -1   -1   -1    -1      -1   123e+/-
  S7   7    -1   -1   -1     8      -1   123e+/-123           (valid)
  S8  -1    -1   -1   -1     8      -1   123e+/-123_          (valid)
  */
  private int[][] initialStateMatrix() {
    return new int[][]{{2,1,-1,3,0,-1},
                       {2,-1,-1,3,-1,-1},
                       {2,-1,5,4,8,-1},
                       {4,-1,-1,-1,-1,-1},
                       {4,-1,5,-1,8,-1},
                       {7,6,-1,-1,-1,-1},
                       {7,-1,-1,-1,-1,-1},
                       {7,-1,-1,-1,8,-1},
                       {-1,-1,-1,-1,8,-1}};
  }
  public boolean isNumber(String s) {
    int state = 0;
    int input;
    int[][] stateMatrix = initialStateMatrix();
    for (int i = 0; i < s.length(); i++) {
      input = getInput(s.charAt(i));
      state = stateMatrix[state][input];
      if (state == -1) return false;
    }
    if (state == 2 || state == 4 || state == 7 || state == 8) return true;
    return false;
  }
  
  private int getInput(Character c) {
    if (c >= '0' && c <= '9') {
      return 0;
    } else if (c == '+' || c == '-') {
      return 1;
    } else if (c == 'e') {
      return 2;
    } else if (c == '.') {
      return 3;
    } else if (c == ' ') {
      return 4;
    } else {
      return 5;
    }
  }
}
// @lc code=end
