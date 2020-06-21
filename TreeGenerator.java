import java.util.*;

public class TreeGenerator { // LC449

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String ss[] = data.split(",");
        if (ss.length == 0) {
            throw new IllegalArgumentException();
        }
        if (ss.length == 1 && ss[0].equals("#")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(ss[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (i < ss.length) {
            TreeNode cur = queue.poll();

            TreeNode left =
                   ss[i].equals("#")
                        ? null : new TreeNode(Integer.valueOf(ss[i]));
            TreeNode right =
                   (++i >= ss.length || ss[i].equals("#"))
                        ? null : new TreeNode(Integer.valueOf(ss[i]));

            cur.left = left;
            cur.right = right;

            if (left != null) {
                queue.offer(left);
            }
            if (right != null) {
                queue.offer(right);
            }

            i++;
        }

        return root;

    }
    public static void main(String[] args) {
        TreeGenerator tg = new TreeGenerator();
        TreeNode root = tg.deserialize("[1,2,5,3,4,#,6]");
        System.out.println(root.val);
    }

}

class TreeNode {
	
	public int val;
	public TreeNode left, right;
	
	public TreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}

}




