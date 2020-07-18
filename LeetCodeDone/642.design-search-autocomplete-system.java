import java.util.*;

/*
 * @lc app=leetcode id=642 lang=java
 *
 * [642] Design Search Autocomplete System
 */

// @lc code=start
class AutocompleteSystem {
    private class TrieNode {
        char val;
        boolean isWord;
        TrieNode[] children;
        Map<String, Integer> getTop3;
        TrieNode(char val) {
            this.val = val;
            this.isWord = false;
            children = new TrieNode[256];
            getTop3 = new HashMap<>();
        }
    }
    private class Trie {
        TrieNode root;
        Map<String, Integer> counts;
        TrieNode searchCur;
        Trie() {
            root = new TrieNode('\0');
            counts = new HashMap<>();
            searchCur = root;
        }
        void insert(String word, Integer count) {
            TrieNode cur = root;
            counts.put(word, count);
            for (char c: word.toCharArray()) {
                if (cur.children[c] == null) {
                    cur.children[c] = new TrieNode(c);
                }
                cur = cur.children[c];
                cur.getTop3.put(word, count);
            }
            cur.isWord = true;
        }
        void searchReset() {
            this.searchCur = root;
        }

        void insert(String word) {
            int count = counts.getOrDefault(word, 0);
            insert(word, count+1);
        }
        List<String> search(char c) {
            List<String> res = new LinkedList<>();
            if(searchCur == null) {
                return res;
            }
            searchCur = searchCur.children[c];
            if(searchCur == null) {
                return res;
            }
            return getTop3(searchCur);
        }

        private List<String> getTop3(TrieNode cur) {
            PriorityQueue<Map.Entry<String,Integer>> heap 
                = new PriorityQueue<>(new Comparator<Map.Entry<String,Integer>>(){
                    @Override
                    public int compare(Map.Entry<String,Integer> e1, Map.Entry<String,Integer> e2) {
                        if (e1.getValue() != e2.getValue()) {
                            return e2.getValue() - e1.getValue();
                        } else {
                            return e1.getKey().compareTo(e2.getKey());
                        }
                    }
                }
            );
            for (Map.Entry<String, Integer> e: cur.getTop3.entrySet()) {
                heap.offer(e);
            }
            List<String> res = new LinkedList<>();
            for (int i = 0; i < 3 && !heap.isEmpty(); i++) {
                res.add(heap.poll().getKey());
            }
            return res;
        }
    }
    Trie trie;
    StringBuilder sb;

    public AutocompleteSystem(String[] sentences, int[] times) {
        if (sentences == null || times == null || sentences.length != times.length) {
            return;
        }
        this.sb = new StringBuilder();
        trie = new Trie();
        for (int i = 0; i < sentences.length;i++) {
            trie.insert(sentences[i], times[i]);
        }
    }
    
    public List<String> input(char c) {
        if (c == '#') {
            trie.insert(sb.toString());
            this.sb = new StringBuilder();
            trie.searchReset();
            return new LinkedList<String>();
        } else {
            this.sb.append(c);
            return trie.search(c);
        }
        
    }
    public static void main(String[] args) {
        String[] sentences = new String[]{"i love you","island","iroman","i love leetcode"};
        int[] times = new int[]{5,3,2,2};
        AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
        obj.input('i');
        obj.input(' ');
        obj.input('a');
        obj.input('#');
        obj.input('i');
        obj.input(' ');

    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
// @lc code=end

