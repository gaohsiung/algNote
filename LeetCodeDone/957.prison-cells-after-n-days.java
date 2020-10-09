import java.util.*;
/*
 * @lc app=leetcode id=957 lang=java
 *
 * [957] Prison Cells After N Days
 */

// @lc code=start
class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        int cur = cellsToBits(cells);
        Map<Integer, Integer> status = new HashMap<>();
        while(n > 0) {
            if (!status.containsKey(cur)) {
                status.put(cur, n);
            } else {
                n = n % (status.get(cur) - n);
            }
            if (n > 0) {
                n--;
                cur = nextDay(cur);
            }
        }
        return bitsToCells(cur);
    }
    private int cellsToBits(int[] cells) {
        int ret = 0;
        for (int c: cells) {
            ret = ret << 1;
            ret = ret | c;
        }
        return ret;
    }
    private int[] bitsToCells(int bits) {
        int[] ret = new int[8];
        for (int i = 7; i >= 0; i--) {
            ret[i] = bits & 1;
            bits = bits >> 1;
        }
        return ret;
    }
    private int nextDay(int cur) {
        int leftOne = cur << 1;
        int rightOne = cur >> 1;
        int next = ~(leftOne ^ rightOne);
        return next & 0x7e;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.prisonAfterNDays(new int[]{0,1,0,1,1,0,0,1}, 7);
    }
    
}
// @lc code=end

