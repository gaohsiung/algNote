import java.util.*;

/*
 * @lc app=leetcode id=973 lang=java
 *
 * [973] K Closest Points to Origin
 */

// @lc code=start
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        if (points == null || points.length <= k || points[0] == null || points[0].length == 0) {
            return points;
        }
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] p1, int[] p2) {
                long dist1 = getDistance(p1);
                long dist2 = getDistance(p2);
                if (dist2 < dist1) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        for (int[] point: points) {
            if (maxHeap.size() < k || getDistance(point) < getDistance(maxHeap.peek())) {
                if (maxHeap.size() == k) {
                    maxHeap.poll();
                }
                maxHeap.offer(point);
            }
        }
        int[][] result = new int[k][];
        int i = 0;
        while(!maxHeap.isEmpty()) {
            result[i] = maxHeap.poll();
            i++;
        }
        return result;
    }
    private long getDistance(int[] point) {
        return ((long)(point[0]))*((long)(point[0])) + ((long)(point[1]))*((long)(point[1]));
    }
}
// @lc code=end

