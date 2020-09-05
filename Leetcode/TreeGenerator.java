import java.util.LinkedList;
import java.util.Queue;

public class TreeGenerator { // LC449

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
        TreeGenerator tg = new TreeGenerator();
        TreeNode root = tg.deserialize("1,2,3,n,n,n,n");
        System.out.println(tg.serialize(root));
    }
}