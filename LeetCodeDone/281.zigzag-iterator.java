import java.util.*;

/*
 * @lc app=leetcode id=281 lang=java
 *
 * [281] Zigzag Iterator
 */

// @lc code=start
public class ZigzagIterator {
    Queue<List<Integer>> helperQueue;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.helperQueue = new LinkedList<>();
        if (v1 != null && v1.size() != 0) {
            this.helperQueue.offer(v1);
        }
        if (v2 != null && v2.size() != 0) {
            this.helperQueue.offer(v2);
        }
    }

    public int next() {
        List<Integer> cur = helperQueue.poll();
        int ret = cur.get(0);
        cur.remove(0);
        if (cur.size() != 0) {
            helperQueue.offer(cur);
        }
        return ret;

    }

    public boolean hasNext() {
        return !this.helperQueue.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
// @lc code=end

