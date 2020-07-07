import java.util.*;

import jdk.javadoc.internal.doclets.formats.html.resources.standard;

/*
 * @lc app=leetcode id=126 lang=java
 *
 * [126] Word Ladder II
 */

// @lc code=start
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        List<List<String>> res = new LinkedList<>();
        for (String w: wordList) {
            dict.add(w);
        }
        if (!dict.contains(endWord)) {
            return res;
        }
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        dict.remove(beginWord);
        Map<String, List<String>> graph = new HashMap<>();
        boolean foundEndWord = false;
        while (!q.isEmpty()) {
            int size = q.size();
            Set<String> levelVisited = new HashSet<>();
            while (size-- > 0) {
                String cur = q.poll();
                List<String> nexts = transform(dict, cur);
                for (String next: nexts) {
                    if (next.equals(endWord)) {
                        foundEndWord = true;
                    }
                    if (!levelVisited.contains(next)) {
                        List<String> temp = new LinkedList<>();
                        temp.add(cur);
                        graph.put(next, temp);
                        q.offer(next);
                        levelVisited.add(next);
                    } else {
                        graph.get(next).add(cur);
                    }
                }
            }
            dict.removeAll(levelVisited);
            if (foundEndWord == true) {
                break;
            }
        }
        if (foundEndWord) {
            List<String> sol = new LinkedList<>();
            sol.add(endWord);
            dfs(endWord, graph, sol, beginWord, res);
        }
        return res;
    }

    private void dfs(String cur, Map<String, List<String>> graph, 
        List<String> sol, String beginWord, List<List<String>> res) {

        if (cur.equals(beginWord)) {
            res.add(new LinkedList<String>(sol));
            return;
        }
        for(String s: graph.get(cur)) {
            sol.add(0, s);
            dfs(s, graph, sol, beginWord, res);
            sol.remove(0);
        }

    }

    private List<String> transform(Set<String> wordList, String cur) {
        List<String> res = new LinkedList<>();
        char[] charCur = cur.toCharArray();
        for (int i = 0; i < charCur.length; i++) {
            char temp = charCur[i];
            for (char c = 'a'; c <= 'z'; c++) {
                charCur[i] = c;
                String newString = new String(charCur);
                if (wordList.contains(newString)) {
                    res.add(newString);
                }
            }
            charCur[i] = temp;
        }
        return res;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        List<String> wordList = Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"});
        System.out.println(sol.findLadders("hit", "cog", wordList));
    }
}
// @lc code=end

