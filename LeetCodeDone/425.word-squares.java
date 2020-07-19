import java.util.*;

/*
 * @lc app=leetcode id=425 lang=java
 *
 * [425] Word Squares
 */

// @lc code=start
class Solution {
    private static class TrieNode{
        char val;
        TrieNode[] children;
        List<String> words;
        TrieNode(char val) {
            this.val = val;
            children = new TrieNode[26];
            words = new LinkedList<>();
        }
    }

    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new LinkedList<>();
        if (words == null || words.length == 0) {
            return res;
        }
        TrieNode root = new TrieNode('\0');
        buildTrie(root, words);

        for (String startString: words) {
            List<String> path = new LinkedList<>();
            path.add(startString);
            dfs(1, root, path, res);
        }
        return res;
    }
    

    private void dfs(int idx, TrieNode root, List<String> path, List<List<String>> res) {
        if (idx == path.get(0).length()) {
            List<String> temp = new LinkedList<>();
            for(String s: path) {
                temp.add(s);
            }
            res.add(temp);
            return;
        }
        StringBuilder prefix = new StringBuilder();
        for (String s: path) {
            prefix.append(s.charAt(idx));
        }
        List<String> possibleNexts = getNextWords(root, prefix);
        if (possibleNexts == null) {
            return;
        }
        for (String s: possibleNexts) {
            path.add(s);
            dfs(idx+1, root, path, res);
            path.remove(path.size() - 1);
        }

    }

    private List<String> getNextWords(TrieNode root, StringBuilder prefix) {
        TrieNode cur = root;
        for(char c: prefix.toString().toCharArray()) {
            if (cur.children[c-'a'] == null) {
                return null;
            }
            cur = cur.children[c-'a'];
        }
        return cur.words;
    }

    private void buildTrie(TrieNode root, String[] words) {
        for(String s: words) {
            TrieNode cur = root;
            for(char c: s.toCharArray()) {
                if (cur.children[c-'a'] == null) {
                    cur.children[c-'a'] = new TrieNode(c);
                }
                cur.children[c-'a'].words.add(s);
                cur = cur.children[c-'a'];
            }
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.wordSquares(new String[]{"area","lead","wall","lady","ball"}));
    }
}
// @lc code=end

