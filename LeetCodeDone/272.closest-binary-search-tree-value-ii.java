import java.util.*;

/*
 * @lc app=leetcode id=272 lang=java
 *
 * [272] Closest Binary Search Tree Value II
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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> lStack = new Stack<>();
        Stack<TreeNode> rStack = new Stack<>();
        initialStack(root, target, lStack, rStack);
        while (k-- > 0) {
            if (lStack.isEmpty() && rStack.isEmpty()) {
                break;
            } else if (lStack.isEmpty()) {
                res.add(rStack.peek().val);
                rStackPop(rStack);
            } else if (rStack.isEmpty()) {
                res.add(lStack.peek().val);
                lStackPop(lStack);
            } else {
                double lDiff = (double) Math.abs(target - lStack.peek().val);
                double rDiff = (double) Math.abs(target - rStack.peek().val);
                if (lDiff < rDiff) {
                    res.add(lStack.peek().val);
                    lStackPop(lStack);
                } else {
                    res.add(rStack.peek().val);
                    rStackPop(rStack);
                }
            }
        }
        return res;
    }

    private void lStackPop(Stack<TreeNode> lStack) {
        TreeNode cur = lStack.pop();
        cur = cur.left;
        while (cur != null) {
            lStack.push(cur);
            cur = cur.right;
        }
    }

    private void rStackPop(Stack<TreeNode> rStack) {
        TreeNode cur = rStack.pop();
        cur = cur.right;
        while (cur != null) {
            rStack.push(cur);
            cur = cur.left;
        }
    }

    private void initialStack(TreeNode root, double target, Stack<TreeNode> lStack, Stack<TreeNode> rStack) {
        while(root != null) {
            if (root.val < target) {
                lStack.push(root);
                root = root.right;
            } else {
                rStack.push(root);
                root = root.left;
            }
        }
    }
}
// @lc code=end

