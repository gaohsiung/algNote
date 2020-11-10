import java.util.*;
/*
 * @lc app=leetcode id=773 lang=java
 *
 * [773] Sliding Puzzle
 */

// @lc code=start
class Solution {
  private final int[][] DIRECTION = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0,1}};
  public int slidingPuzzle(int[][] board) {
    // c.c.

    
    Set<String> visited = new HashSet<>();
    Queue<String> queue = new LinkedList<>();
    String startStatus = matrixToString(board);
    if (startStatus.equals("123450")) {
      return 0;
    }
    queue.offer(startStatus);
    visited.add(startStatus);
    int stepCount = 1;
    while(!queue.isEmpty()) {
      int size = queue.size();
      while(size-- > 0) {
        String cur = queue.poll();
        for (String nextStatus: transfer(cur)) {
          if (nextStatus.equals("123450")) {
            return stepCount;
          }
          if (visited.add(nextStatus)) {
            queue.offer(nextStatus);
          }
        }
      }
      stepCount++;
    }
    return -1;
  }

  private String matrixToString(int[][] matrix) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        sb.append(matrix[i][j]);
      }
    }
    return sb.toString();
  }
  private int[][] stringToMatrix(String s) {
    int[][] res = new int[2][3];
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 3; j++) {
        res[i][j] = s.charAt(i*3+j) - '0';
      }
    }
    return res;
  }
  private List<String> transfer(String s) {
    int[][] curBoard = stringToMatrix(s);
    int row = curBoard.length;
    int col = curBoard[0].length;
    List<String> res = new ArrayList<>();
    int curZero = findZeroPoint(curBoard);
    int i = curZero / col;
    int j = curZero % col;
    for (int[] dir: DIRECTION) {
      int ii = i + dir[0];
      int jj = j + dir[1];
      if (ii >= 0 && ii < row && jj >= 0 && jj < col) {
        swap(curBoard, i, j, ii, jj);
        res.add(matrixToString(curBoard));
        swap(curBoard, i, j, ii, jj);
      }
    }
    return res;
  }
  private void swap(int[][] board, int i, int j, int ii, int jj) {
    int temp = board[i][j];
    board[i][j] = board[ii][jj];
    board[ii][jj] = temp;
  }

  private int findZeroPoint(int[][] board) {
    int row = board.length;
    int col = board[0].length;
    int cur = -1;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (board[i][j] == 0) {
          cur = i * col + j;
          break;
        }
      }
    }
    if (cur == -1) {
      throw new IllegalArgumentException();
    }
    return cur;
  }
}
// @lc code=end
