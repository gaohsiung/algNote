import java.util.*;

/*
 * @lc app=leetcode id=378 lang=java
 *
 * [378] Kth Smallest Element in a Sorted Matrix
 */

// @lc code=start
class Solution {

    private class Cell implements Comparable<Cell> {
        int i;
        int j;
        int val;
        Cell(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }
        @Override
        public int compareTo(Cell that) {
            return this.val - that.val;
        }
        @Override
        public int hashCode() {
            return this.i*31+this.j;
        }
        @Override
        public boolean equals(Object o) {
            if (o == null) return false;
            if (o instanceof Cell) {
                Cell that = (Cell) o;
                return (this.i == that.i) && (this.j == that.j);
            } else {
                return false;
            }
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        // c.c.

        int row = matrix.length;
        int col = matrix[0].length;
        PriorityQueue<Cell> heap = new PriorityQueue<>();
        Set<Cell> visited = new HashSet<>();
        int curVal = matrix[0][0];
        heap.offer(new Cell(0,0,curVal));
        visited.add(new Cell(0,0,curVal));
        while(k-->0 && (!heap.isEmpty())) {
            Cell cur = heap.poll();
            curVal = cur.val;
            if (cur.i + 1 < row) {
                Cell rightCell = new Cell(cur.i+1, cur.j, matrix[cur.i+1][cur.j]);
                if (visited.add(rightCell)){
                    heap.offer(rightCell);
                }
            }
            if (cur.j+1 < col) {
                Cell downCell = new Cell(cur.i, cur.j+1, matrix[cur.i][cur.j+1]);
                if (visited.add(downCell)) {
                    heap.offer(downCell);
                }
            }
        }
        return curVal;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.kthSmallest(new int[][]{{1,3,5},{6,7,12},{11,14,14}}, 6));
    }
}
// @lc code=end

