import java.util.*;

/*
 * @lc app=leetcode id=314 lang=java
 *
 * [314] Binary Tree Vertical Order Traversal
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
    class MyNode {
        TreeNode node;
        int col;
        MyNode(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<MyNode> q = new LinkedList<>();
        q.offer(new MyNode(root, 0));
        while (!q.isEmpty()) {
            MyNode cur = q.poll();
            if (cur.node != null) {
                if (!map.containsKey(cur.col)) {
                    map.put(cur.col, new LinkedList<Integer>());
                }
                map.get(cur.col).add(cur.node.val);
                q.offer(new MyNode(cur.node.left, cur.col-1));
                q.offer(new MyNode(cur.node.right, cur.col+1));
            }
        }
        for (int i = map.firstKey(); i<=map.lastKey(); i++) {
            if(map.containsKey(i)) {
                res.add(map.get(i));
            }
        }
        

        return res;
    }

    
    public static void main(String[] args) {
        TreeNode t7 = new TreeNode(7, null, null);
        TreeNode t6 = new TreeNode(6, null, null);
        TreeNode t5 = new TreeNode(5, null, null);
        TreeNode t4 = new TreeNode(4, null, null);
        TreeNode t3 = new TreeNode(3, t6, t7);
        TreeNode t2 = new TreeNode(2, t4, t5);
        TreeNode t1 = new TreeNode(1, t2, t3);
        Solution sol = new Solution();
        System.out.println(sol.verticalOrder(t1));

    }


}
// @lc code=end

// another solution
// public List<List<Integer>> verticalOrder(TreeNode root) {
//     List<List<Integer>> res = new LinkedList<>();
//     if (root == null) {
//         return res;
//     }
//     // initialize q
//     Queue<TreeNode> q = new LinkedList<>();
//     q.offer(root);
//     // helper hashmap
//     int leftMostKey = 0;
//     Map<Integer, List<Integer>> addResult = new HashMap<>();
//     Map<TreeNode, Integer> getVerticalIndex = new HashMap<>();
//     addResult.put(0, new LinkedList<Integer>());
//     addResult.get(0).add(root.val);
//     getVerticalIndex.put(root, 0);
//     while(!q.isEmpty()) {
//         TreeNode cur = q.poll();
//         int curVerticalIndex = getVerticalIndex.get(cur);
//         if(cur.left != null) {
//             getVerticalIndex.put(cur.left, curVerticalIndex - 1);
//             if(!addResult.containsKey(curVerticalIndex - 1)) {
//                 addResult.put(curVerticalIndex - 1, new LinkedList<Integer>());
//             }
//             addResult.get(curVerticalIndex - 1).add(cur.left.val);
//             leftMostKey = Math.min(curVerticalIndex - 1, leftMostKey);
//             q.offer(cur.left);
//         }
//         if (cur.right != null) {
//             getVerticalIndex.put(cur.right, curVerticalIndex + 1);
//             if(!addResult.containsKey(curVerticalIndex + 1)) {
//                 addResult.put(curVerticalIndex + 1, new LinkedList<Integer>());
//             }
//             addResult.get(curVerticalIndex + 1).add(cur.right.val);
//             q.offer(cur.right);
//         }
//     }
//     for(int i = leftMostKey; addResult.containsKey(i); i++) {
//         res.add(addResult.get(i));
//     }
//     return res;
// }

