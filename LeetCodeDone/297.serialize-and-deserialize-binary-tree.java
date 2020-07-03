import java.util.*;

/*
 * @lc app=leetcode id=297 lang=java
 *
 * [297] Serialize and Deserialize Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur == null) {
                sb.append("n,");
                continue;
            }
            sb.append(String.valueOf(cur.val));
            sb.append(",");
            q.offer(cur.left);
            q.offer(cur.right);
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String s) {
        if (s.equals("")) {
            return null;
        }
        String[] vals = s.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i = 1;
        while(i < vals.length) {
            TreeNode cur = q.poll();
            if (!(vals[i]).equals("n")) {
                cur.left = new TreeNode(Integer.parseInt(vals[i]));
                q.offer(cur.left);
            } else {
                cur.left = null;
            }
            i++;
            if (!(vals[i]).equals("n")) {
                cur.right = new TreeNode(Integer.parseInt(vals[i]));
                q.offer(cur.right);
            } else {
                cur.right = null;
            }
            i++;
        }
        return root;
    }
    

    public static void main(String[] args) {
        Codec cod = new Codec();
        TreeNode t7 = new TreeNode(7, null, null);
        TreeNode t6 = new TreeNode(6, null, null);
        TreeNode t5 = new TreeNode(5, null, null);
        TreeNode t4 = new TreeNode(4, null, null);
        TreeNode t3 = new TreeNode(3, t6, t7);
        TreeNode t2 = new TreeNode(2, t4, t5);
        TreeNode t1 = new TreeNode(1, t2, t3);
        System.out.println(cod.deserialize("1,2,3,4,5,6,7,null,null,null,null,null,null,null,null"));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
// @lc code=end

//dfs preorder
/*
public String serialize(TreeNode root) {
    StringBuilder sb = dfs(root, new StringBuilder());
    sb.setLength(sb.length() - 1);
    return sb.toString();
}

private StringBuilder dfs(TreeNode root, StringBuilder sb) {
    if (root == null) {
        return sb.append("null,");
    }
    sb.append(root.val);
    sb.append(",");
    sb = dfs(root.left, sb);
    sb = dfs(root.right, sb);
    return sb;
}

// Decodes your encoded data to tree.
public TreeNode deserialize(String s) {
    if (s.equals("")) {
        return null;
    }

    List<String> vals = new ArrayList<>(Arrays.asList(s.split(",")));
    TreeNode root = dfs2(vals);
    return root;
}



private TreeNode dfs2(List<String> vals) {
    if (vals.get(0).equals("null")) {
        vals.remove(0);
        return null;
    }
    TreeNode root = new TreeNode(Integer.parseInt(vals.get(0)));
    vals.remove(0);
    root.left = dfs2(vals);
    root.right = dfs2(vals);
    return root;
}
*/