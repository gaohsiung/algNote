import java.util.*;

/*
 * @lc app=leetcode id=403 lang=java
 *
 * [403] Frog Jump
 */

// @lc code=start
class Solution {
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) {
            return true;
        }
        HashMap<Integer, Boolean>[] mem = new HashMap[stones.length];
        return dfs(stones, 0, 1, mem);
    }

    private boolean dfs(int[] stones, int index, int k, HashMap<Integer, Boolean>[] mem) {
        if (index == stones.length - 1) {
            return true;
        }
        if (mem[index] == null) {
            mem[index] = new HashMap<>();
        }

        if(mem[index].containsKey(k)) {
            return mem[index].get(k);
        }
        for (int i = index + 1; i < stones.length; i++) {
            int dist = stones[i] - stones[index];
            if (index == 0 && dist > k) {
                return false;
            }
            if (dist < k - 1) {
                continue;
            } else if (dist > k + 1) {
                break;
            } else {
                if (dfs(stones, i, dist, mem)) {
                    mem[index].put(k, true);
                    return true;
                }
            }
        }
        mem[index].put(k, false);
        return false;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.canCross(new int[]{0,2}));
    }
}
// @lc code=end

// remember to handle the edge case at index 0 where the jump is avaible only when dist <= 1

