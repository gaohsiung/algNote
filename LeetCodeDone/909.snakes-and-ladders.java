import java.util.*;

/*
 * @lc app=leetcode id=909 lang=java
 *
 * [909] Snakes and Ladders
 */

// @lc code=start
class Solution {
    public int snakesAndLadders(int[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length <= 1) {
            return 0;
        }
        int row = board.length;
        int col = board[0].length;
        int target = col*col;
        Set<Integer> checkVisited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        checkVisited.add(1);
        queue.offer(1);
        int minLen = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                int ordinal = queue.poll();
                if (ordinal == target) return minLen;
                for(int i = 1; i <= 6; i++) {
                    if (ordinal + i > target) break;
                    int[] index = ordinalToInd(row, col, ordinal + i);
                    int next;
                    if (board[index[0]][index[1]] == -1) {
                        next = ordinal + i;
                    } else {
                        next = board[index[0]][index[1]];
                    }
                    if (!checkVisited.contains(next)) {
                        checkVisited.add(next);
                        queue.offer(next);
                    }
                }
            }
            minLen++;
        }
        return -1;
    }
    private int[] ordinalToInd(int row, int col, int ordinal) {
        ordinal--;
        if ((ordinal / col)%2 == 0) {
            return new int[]{row - 1 - ordinal/col, ordinal % col};
        } else {
            return new int[]{row - 1 - ordinal/col, col - 1 - ordinal%col};
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.snakesAndLadders(new int[][]{{-1,-1,-1,46,47,-1,-1,-1},
                                                            {51,-1,-1,63,-1,31,21,-1},
                                                            {-1,-1,26,-1,-1,38,-1,-1},
                                                            {-1,-1,11,-1,14,23,56,57},
                                                            {11,-1,-1,-1,49,36,-1,48},
                                                            {-1,-1,-1,33,56,-1,57,21},
                                                            {-1,-1,-1,-1,-1,-1,2,-1},
                                                            {-1,-1,-1,8,3,-1,6,56}}));
    }
}
// @lc code=end

