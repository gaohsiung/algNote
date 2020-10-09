import java.util.*;
/*
 * @lc app=leetcode id=752 lang=java
 *
 * [752] Open the Lock
 */

// @lc code=start
class Solution {
    public int openLock(String[] deadends, String target) {
        if (target.length() != 4) throw new IllegalArgumentException();

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        for (String de: deadends) {
            visited.add(de);
        }
        String cur = "0000";
        if (visited.contains(cur)) return -1; // important!
        if (cur.equals(target)) return 0; // edge case! important!
        visited.add(cur);
        queue.offer(cur);
        int minLen = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size -- > 0) {
                cur = queue.poll();
                List<String> nexts = convert(cur);
                for (String next: nexts) {
                    if (visited.contains(next)) {
                        continue;
                    }
                    if (next.equals(target)) {
                        return minLen;
                    }
                    visited.add(next);
                    queue.offer(next);
                }
            }
            minLen++;
        }
        return -1;
    }
    private List<String> convert(String cur) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder(cur);
        for(int i = 0; i < cur.length(); i++) {
            char old = sb.charAt(i);
            sb.setCharAt(i, (char)(((old - '0' + 10 + 1) % 10) + '0'));
            res.add(sb.toString());
            sb.setCharAt(i, old);
            sb.setCharAt(i, (char)(((old - '0' + 10 - 1) % 10) + '0'));
            res.add(sb.toString());
            sb.setCharAt(i, old);
        }
        return res;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.openLock(new String[]{"0201","0101","0102","1212","2002"}, "0202"));
    }
}
// @lc code=end

