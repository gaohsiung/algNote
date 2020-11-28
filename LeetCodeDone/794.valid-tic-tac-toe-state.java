/*
 * @lc app=leetcode id=794 lang=java
 *
 * [794] Valid Tic-Tac-Toe State
 */

// @lc code=start
class Solution {
  public boolean validTicTacToe(String[] board) {
    int countP1 = 0;
    int countP2 = 0;
    int[] rowStatus = new int[3];
    int[] colStatus = new int[3];
    int diagStatus = 0;
    int antidiagStatus = 0;
    boolean p1Win = false;
    boolean p2Win = false;
    for (int r = 0; r < 3; r++) {
      for (int c = 0; c < 3; c++) {
        if (board[r].charAt(c) == 'X') {
          countP1++;
          rowStatus[r]++;
          colStatus[c]++;
          if (r == c) {
            diagStatus++;
          }
          if (r + c == 2) {
            antidiagStatus++;
          }
        }
        if (board[r].charAt(c) == 'O') {
          countP2++;
          rowStatus[r]--;
          colStatus[c]--;
          if (r == c) {
            diagStatus--;
          }
          if (r + c == 2) {
            antidiagStatus--;
          }
        }
      }
    }
    for (int i = 0; i < 3; i++) {
      if (rowStatus[i] == 3 || colStatus[i] == 3) {
        p1Win = true;
      }
      if (rowStatus[i] == -3 || colStatus[i] == -3) {
        p2Win = true;
      }
    }
    if (diagStatus == 3 || antidiagStatus == 3) {
      p1Win = true;
    }
    if (diagStatus == -3 || antidiagStatus == -3) {
      p2Win = true;
    }
    if (!(countP1 == countP2 || countP1 == countP2 + 1)) return false;
    if (p1Win && p2Win) return false;
    if ((countP1 == countP2+1 && p1Win) || (countP1 == countP2 && p2Win)) {
      return true;
    }
    if (p1Win || p2Win) return false;
    return true;
    
  }
}
// @lc code=end
