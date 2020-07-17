import java.util.*;

/*
 * @lc app=leetcode id=653 lang=java
 *
 * [653] Two Sum IV - Input is a BST
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
    public boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> lStack = new Stack<>();
        Stack<TreeNode> rStack = new Stack<>();
        initialLStack(root, lStack);
        initialRStack(root, rStack);
        TreeNode curLeft = lStack.peek();
        TreeNode curRight = rStack.peek();
        while (curLeft != curRight) {
            int val = curLeft.val + curRight.val;
            if (val == k) {
                return true;
            } else if (val > k) {
                rStackPop(rStack);
                curRight = rStack.peek();
            } else {
                lStackPop(lStack);
                curLeft = lStack.peek();
                
            }
        }
        return false;
    }

    private void lStackPop(Stack<TreeNode> lStack) {
        TreeNode cur = lStack.pop();
        cur = cur.right;
        while (cur != null) {
            lStack.push(cur);
            cur = cur.left;
        }
    }

    private void rStackPop(Stack<TreeNode> rStack) {
        TreeNode cur = rStack.pop();
        cur = cur.left;
        while(cur != null) {
            rStack.push(cur);
            cur = cur.right;
        }
    }

    private void initialLStack(TreeNode root, Stack<TreeNode> lStack) {
        while(root != null) {
            lStack.push(root);
            root = root.left;
        }
    }

    private void initialRStack(TreeNode root, Stack<TreeNode> rStack) {
        while(root != null) {
            rStack.push(root);
            root = root.right;
        }
    }

}
// @lc code=end

