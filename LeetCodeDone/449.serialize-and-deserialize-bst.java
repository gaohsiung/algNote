import java.util.*;
/*
 * @lc app=leetcode id=449 lang=java
 *
 * [449] Serialize and Deserialize BST
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Codec {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if (root == null) {
      return "";
    }
    StringBuilder sb = new StringBuilder();
    TreeNode cur = root;
    Deque<TreeNode> stack = new ArrayDeque<>();
    while (cur != null || !stack.isEmpty()) {
      if (cur != null) {
        sb.append(cur.val);
        sb.append(",");
        stack.push(cur);
        cur = cur.left;
      } else {
        TreeNode top = stack.pop();
        cur = top.right;
      }
    }
    sb.setLength(sb.length() - 1);
    return sb.toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data.equals("")) return null;
    String[] nodes = data.split(",");
    int len = nodes.length;
    int[] preorders = new int[len];
    int[] inorders = new int[len];
    for (int i = 0; i < len; i++) {
      preorders[i] = Integer.valueOf(nodes[i]);
      inorders[i] = preorders[i];
    }
    Arrays.sort(inorders);
    TreeNode root = construct(0, 0, len-1, preorders, inorders);
    return root;
  }
  private TreeNode construct(int preorderIdx, int inorderStart, int inorderEnd, int[] preorders, int[] inorders) {
    if (inorderStart > inorderEnd) {
      return null;
    }
    TreeNode root = new TreeNode(preorders[preorderIdx]);
    int inorderIdx = -1;
    for (int i = 0; i < inorders.length; i++) {
      if (inorders[i] == preorders[preorderIdx]) {
        inorderIdx = i;
        break;
      }
    }
    root.left = construct(preorderIdx+1, inorderStart, inorderIdx-1, preorders, inorders);
    root.right = construct(preorderIdx+(inorderIdx - inorderStart + 1), inorderIdx+1, inorderEnd, preorders, inorders);
    return root;
  }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
// @lc code=end
// general BT dfs serialization