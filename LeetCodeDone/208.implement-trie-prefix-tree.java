/*
 * @lc app=leetcode id=208 lang=java
 *
 * [208] Implement Trie (Prefix Tree)
 */

// @lc code=start
class Trie {
    private static class TrieNode {
        char val;
        TrieNode[] children;
        boolean isWord;
        TrieNode(char val){
            this.val = val;
            children = new TrieNode[256];
            isWord =false;
        }
    }
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode('\0');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for(char c: word.toCharArray()) {
            if (cur.children[c] == null) {
                cur.children[c] = new TrieNode(c);
            }
            cur = cur.children[c];
        }
        cur.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for(char c: word.toCharArray()) {
            if (cur.children[c] == null) {
                return false;
            }
            cur = cur.children[c];
        }
        return cur.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(char c: prefix.toCharArray()) {
            if (cur.children[c] == null) {
                return false;
            }
            cur = cur.children[c];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end

