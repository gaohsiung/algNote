import java.util.*;

/*
 * @lc app=leetcode id=212 lang=java
 *
 * [212] Word Search II
 */

// @lc code=start
class Solution {
    private static class TrieNode{
        char val;
        boolean isWord;
        TrieNode[] children;
        TrieNode(char val) {
            this.val = val;
            this.isWord = false;
            children = new TrieNode[26];
        }
    }
    private static final int[][] DIRECTIONS = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new LinkedList<>();
        // c.c.
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0 || words == null || words.length == 0){
            return res;
        }
        // build trie
        TrieNode root = new TrieNode('\0');
        for(String s: words) {
            TrieNode cur = root;
            for(char c: s.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode(c);
                }
                cur = cur.children[c - 'a'];
            }
            cur.isWord = true;
        }
        // dfs search
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, visited, new StringBuilder(), res);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int i, int j, TrieNode curTrieNode, 
                     Set<Integer> visited, StringBuilder path, List<String> res) {
        int row = board.length;
        int col = board[0].length;
        char c = board[i][j];
        TrieNode next = curTrieNode.children[c - 'a'];
        if (next == null) {
            return;
        }
        int tempLen = path.length();
        path.append(c);
        visited.add(i* col + j);
        if (next.isWord) {
            res.add(path.toString());
            next.isWord = false;
        }
        for (int[] dir: DIRECTIONS) {
            int ii = i + dir[0];
            int jj = j + dir[1];
            if (ii >= 0 && ii < row && jj >= 0 && jj < col && (!visited.contains(ii*col+jj))) {
                dfs(board, ii, jj, next, visited, path, res);
            }
        }
        path.setLength(tempLen);
        visited.remove(i* col + j);
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        // sol.findWords(new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','h','k','r'},{'i','f','l','v'}}, new String[]{"oath","pea","eat","rain"});
        sol.findWords(new char[][]{{'a'}}, new String[]{"a"});
    }
}
// @lc code=end

