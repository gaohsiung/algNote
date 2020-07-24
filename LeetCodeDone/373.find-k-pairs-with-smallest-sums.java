import java.util.*;

/*
 * @lc app=leetcode id=373 lang=java
 *
 * [373] Find K Pairs with Smallest Sums
 */

// @lc code=start
class Solution {
    class Cell implements Comparable<Cell>{
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
        public boolean equals(Object o) {
            if (o == null) return false;
            if (o instanceof Cell) {
                Cell that = (Cell) o;
                return (this.i == that.i) && (this.j == that.j);
            } else {
                return false;
            }
        }
        @Override
        public int hashCode() {
            return 31*i+j;
        }
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // c.c.
        List<List<Integer>> res = new ArrayList<>();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k <= 0) {
            return res;
        }
        PriorityQueue<Cell> heap = new PriorityQueue<>();
        Set<Cell> visited = new HashSet<>();
        Cell first = new Cell(0, 0, nums1[0]+nums2[0]);
        heap.offer(first);
        visited.add(first);
        while(k -- > 0 && (!heap.isEmpty())) {
            Cell cur = heap.poll();
            res.add(Arrays.asList(nums1[cur.i], nums2[cur.j]));
            if(cur.i + 1 < nums1.length) {
                Cell addnum1 = new Cell(cur.i+1, cur.j, nums1[cur.i+1]+nums2[cur.j]);
                if (visited.add(addnum1)) {
                    heap.offer(addnum1);
                }
            }
            if(cur.j + 1 < nums2.length) {
                Cell addnum2 = new Cell(cur.i, cur.j+1, nums1[cur.i]+nums2[cur.j+1]);
                if (visited.add(addnum2)) {
                    heap.offer(addnum2);
                }
            }
        }
        return res;
    }
}
// @lc code=end

