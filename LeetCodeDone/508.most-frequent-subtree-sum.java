import java.util.*;

/*
 * @lc app=leetcode id=508 lang=java
 *
 * [508] Most Frequent Subtree Sum
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private Map<Integer, Integer> sumCounts;
    public int[] findFrequentTreeSum(TreeNode root) {
        this.sumCounts = new HashMap<>();
        if (root == null) {
            return new int[0];
        }
        checkSum(root);
        Map<Integer, List<Integer>> countSum = new HashMap<>();
        for (Map.Entry<Integer, Integer> e: sumCounts.entrySet()) {
            if (countSum.containsKey(e.getValue())) {
                countSum.get(e.getValue()).add(e.getKey());
            } else {
                List<Integer> tempList = new ArrayList<>();
                tempList.add(e.getKey());
                countSum.put(e.getValue(), tempList);
            }
        }
        int max = 0;
        for (Map.Entry<Integer, List<Integer>> e: countSum.entrySet()) {
            if (e.getKey() > max) {
                max = e.getKey();
            }
        }
        int[] res = new int[countSum.get(max).size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = countSum.get(max).get(i);
        }
        return res;
    }

    private int checkSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = checkSum(root.left);
        int rightSum = checkSum(root.right);
        int curSum = leftSum + rightSum + root.val;
        this.sumCounts.put(curSum, this.sumCounts.getOrDefault(curSum, 0) + 1);
        return curSum;
    }
}
// @lc code=end

