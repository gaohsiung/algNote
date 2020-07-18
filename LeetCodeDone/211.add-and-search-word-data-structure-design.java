/*
 * @lc app=leetcode id=211 lang=java
 *
 * [211] Add and Search Word - Data structure design
 */

// @lc code=start
class WordDictionary {
    private static class TrieNode {
        boolean isWord;
        char val;
        TrieNode[] children;
        TrieNode(char c) {
            this.isWord = false;
            val = c;
            children = new TrieNode[256];
        }
    }
    TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode('\0');
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        for(char c: word.toCharArray()) {
            if (cur.children[c] == null) {
                cur.children[c] = new TrieNode(c);
            }
            cur = cur.children[c];
        }
        cur.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        return dfs(root, 0, word);
        
    }

    private boolean dfs(TrieNode curTrie, int idx, String word) {
        if (curTrie == null) {
            return false;
        }
        if (idx == word.length()) {
            return curTrie.isWord;
        }
        char curChar = word.charAt(idx);
        if (curChar >= 'a' && curChar <= 'z') {
            if (dfs(curTrie.children[curChar], idx+1, word)){
                return true;
            } else {
                return false;
            }
        } else if (curChar == '.') {
            for (TrieNode tn: curTrie.children) {
                if (dfs(tn, idx+1, word)) {
                    return true;
                }
            }
            return false;
        } else {
            throw new IllegalArgumentException("Contains other than a-z and .");
        }

    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end

