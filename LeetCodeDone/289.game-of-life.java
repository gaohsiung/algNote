import java.util.*;

/*
 * @lc app=leetcode id=289 lang=java
 *
 * [289] Game of Life
 */

// @lc code=start
class Solution {
    private static final int[][]DIRECTIONS = new int[][]{{-1,-1},{-1,0},{-1,1}, {0,-1},{0,1}, {1,-1},{1,0}, {1,1}};
    public void gameOfLife(int[][] board) {
        Map<Integer, Integer> map = new HashMap<>(); // get prev value
        map.put(0, 0); // prev is 0 not visited
        map.put(10, 0); // prev is 0 next is 0
        map.put(20, 0); // prev is 0 next is 1
        map.put(1,1); // prev is 1 not visited
        map.put(11, 1); // prev is 1 next is 0
        map.put(21,1); // prev is 1 next is 1
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                changeStatus(board, i, j, map);
            }
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 10 || board[i][j] == 11) {
                    board[i][j] = 0;
                } else if (board[i][j] == 20 || board[i][j] == 21){
                    board[i][j] = 1;
                }
            }
        }
    }
    public void changeStatus(int[][] board, int i, int j, Map<Integer, Integer> map) {
        int surroundingCellNumber = 0;
        for(int[] dir: DIRECTIONS) {
            int ii = i + dir[0];
            int jj = j + dir[1];
            if (ii >= 0 && ii < board.length && jj >= 0 && jj < board[0].length) {
                surroundingCellNumber += map.get(board[ii][jj]);
            }
        }
        if (map.get(board[i][j]) == 1) {
            if (surroundingCellNumber == 2 || surroundingCellNumber == 3) {
                board[i][j] = 21;
            } else {
                board[i][j] = 11;
            }
        } else {
            if (surroundingCellNumber == 3) {
                board[i][j] = 20;
            } else {
                board[i][j] = 10;
            }
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.gameOfLife(new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}});
    }
}
// @lc code=end

