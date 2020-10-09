import java.util.*;
/*
 * @lc app=leetcode id=1268 lang=java
 *
 * [1268] Search Suggestions System
 */

// @lc code=start
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        Arrays.sort(products);
        Trie trie = new Trie();
        for (String product: products) {
            trie.insert(product);
        }
        for (int i = 1; i <= searchWord.length(); i++) {
            res.add(trie.search(searchWord.substring(0, i)));
        }
        return res;
    }
}
class TrieNode {
    TrieNode[] children;
    List<String> top3;

    TrieNode() {
        this.children = new TrieNode[26];
        this.top3 = new ArrayList<>();
    }
}
class Trie {
    TrieNode root;
    
    Trie() {
        this.root = new TrieNode();
    }
    void insert(String str) {
        TrieNode cur = this.root;
        for(char c: str.toCharArray()) {
            if (cur.children[c-'a'] == null) {
                cur.children[c-'a'] = new TrieNode();
            }
            if (cur.children[c-'a'].top3.size() < 3) {
                cur.children[c-'a'].top3.add(str);
            }
            cur = cur.children[c-'a'];
        }
    }

    List<String> search(String str) {
        TrieNode cur = this.root;
        for (char c: str.toCharArray()) {
            if (cur.children[c-'a'] == null) {
                return new ArrayList<String>();
            }
            cur = cur.children[c-'a'];
        }
        return cur.top3;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.suggestedProducts(new String[]{"havana"}, "tatiana"));
    }

}
// @lc code=end

