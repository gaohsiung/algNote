import java.util.*;

/*
 * @lc app=leetcode id=218 lang=java
 *
 * [218] The Skyline Problem
 */

// @lc code=start
class Solution {
    private class Endpoint implements Comparable<Endpoint>{
        int val;
        boolean isStart;
        int height;
        Endpoint(int val, boolean isStart, int height) {
            this.val = val;
            this.isStart = isStart;
            this.height = height;
        }
        @Override
        public int compareTo(Endpoint that) {
            if(this.val != that.val) {
                return this.val - that.val;
            }
            if (this.isStart && that.isStart) {
                return that.height - this.height;
            }
            if ((!this.isStart) && (!this.isStart)) {
                return this.height - that.height;
            }
            return this.isStart? -1:1;
        }
    }
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        if (buildings == null || buildings.length == 0 || buildings[0] == null || buildings[0].length == 0) {
            return res;
        }

        List<Endpoint> sortEndpoints = new ArrayList<>();
        for(int[] build: buildings) {
            Endpoint startEndpoint = new Endpoint(build[0], true, build[2]);
            sortEndpoints.add(startEndpoint);
            sortEndpoints.add(new Endpoint(build[1], false, build[2]));
        }
        Collections.sort(sortEndpoints);
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });
        maxHeap.offer(sortEndpoints.get(0).height);
        res.add(Arrays.asList(sortEndpoints.get(0).val, sortEndpoints.get(0).height));
        for(int i = 1; i < sortEndpoints.size(); i++) {
            Endpoint cur = sortEndpoints.get(i);
            if (cur.isStart) {
                if (maxHeap.size() == 0 || cur.height > maxHeap.peek()) {
                    res.add(Arrays.asList(cur.val, cur.height));
                }
                maxHeap.add(cur.height);
            } else {
                maxHeap.remove(cur.height);   // <----- remove O(n)
                if (maxHeap.size() == 0) {
                    res.add(Arrays.asList(cur.val, 0));
                } else if (cur.height > maxHeap.peek()) {
                    res.add(Arrays.asList(cur.val, maxHeap.peek()));
                }
            }
        }
        return res;
    }
}
// @lc code=end

