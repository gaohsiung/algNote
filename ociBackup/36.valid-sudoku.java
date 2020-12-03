import java.util.*;

/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<HashSet<Integer>> rows = new ArrayList<>();
        List<HashSet<Integer>> cols = new ArrayList<>();
        List<HashSet<Integer>> boxs = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            rows.add(new HashSet<Integer>());
            cols.add(new HashSet<Integer>());
            boxs.add(new HashSet<Integer>());
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int cur = (int) board[i][j];
                int boxNo = (i/3)*3 +  j/3;
                if (!(rows.get(i).add(cur) && cols.get(j).add(cur) && boxs.get(boxNo).add(cur))) {
                    return false;
                }
            }
        }
        return true;

        
    }
}
// @lc code=end

