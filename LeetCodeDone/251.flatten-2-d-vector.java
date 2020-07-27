import java.util.*;

/*
 * @lc app=leetcode id=251 lang=java
 *
 * [251] Flatten 2D Vector
 */

// @lc code=start
class Vector2D {
    Queue<int[]> helper;
    int curIdx;
    public Vector2D(int[][] v) {
        helper = new LinkedList<>();
        this.curIdx = 0;
        for(int[] i: v) {
            if (i.length > 0) {
                helper.offer(i);
            }
        }
    }
    
    public int next() {
        int[] cur = helper.peek();
        int ret = cur[this.curIdx++];
        if (this.curIdx == cur.length) {
            this.curIdx = 0;
            helper.poll();
        }
        return ret;



        
    }
    
    public boolean hasNext() {
        return !helper.isEmpty();
    }


}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(v);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
// @lc code=end

