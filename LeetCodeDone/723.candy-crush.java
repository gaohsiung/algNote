import java.util.*;
/*
 * @lc app=leetcode id=723 lang=java
 *
 * [723] Candy Crush
 */

// @lc code=start
class Solution {
  public int[][] candyCrush(int[][] board) {
    int row = board.length;
    int col = board[0].length;

    while (true) {
      Set<Integer> isCrushIdx = new HashSet<>();
      for (int r = 0; r < row; r++) {
        checkRow(board, r, isCrushIdx);
      }
      for (int c = 0; c < col; c++) {
        checkCol(board, c, isCrushIdx);
      }
      if (!isCrushIdx.isEmpty()) {
        fallBoard(board, isCrushIdx);
      } else {
        break;
      }
    }
    return board;
  }
  private void fallBoard(int[][] board, Set<Integer> isCrushIdx) {
    int row = board.length;
    int col = board[0].length;
    for (int c = 0; c < col; c++) {
      int r = row - 1;
      int cur = row - 1;
      while (r >= 0) {
        if (!isCrushIdx.contains(r*col + c)) {
          board[cur--][c] = board[r--][c];
        } else {
          r--;
        }
      }
      while (cur >= 0) {
        board[cur--][c] = 0;
      }
    }
  }
  private void checkCol(int[][] board, int c, Set<Integer> isCrushIdx) {
    int row = board.length;
    int col = board[0].length;
    if (row < 3) return;
    for (int r = 0; r < row-2; r++) {
      if (board[r][c] != 0 && board[r][c] == board[r+1][c] && board[r+1][c] == board[r+2][c]) {
        isCrushIdx.add(r * col + c);
        isCrushIdx.add((r+1) * col + c);
        isCrushIdx.add((r+2) * col + c);
      }
    }
  }
  private void checkRow(int[][] board, int r, Set<Integer> isCrushIdx) {
    int row = board.length;
    int col = board[0].length;
    if (col < 3) return;
    for (int c = 0; c < col-2; c++) {
      if (board[r][c] != 0 && board[r][c] == board[r][c+1] && board[r][c+1] == board[r][c+2]) {
        isCrushIdx.add(r * col + c);
        isCrushIdx.add(r * col + c+1);
        isCrushIdx.add(r * col + c+2);
      }
    }
  }
  public static void main(String[] args) {
    Solution sol = new Solution();
    sol.candyCrush(new int[][]{{110,5,112,113,114},{210,211,5,213,214},{310,311,3,313,314},{410,411,412,5,414},{5,1,512,3,3},{610,4,1,613,614},{710,1,2,713,714},{810,1,2,1,1},{1,1,2,2,2},{4,1,4,4,1014}});
  }
}
// @lc code=end
