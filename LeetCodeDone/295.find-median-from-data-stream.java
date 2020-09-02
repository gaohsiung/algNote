import java.util.*;

/*
 * @lc app=leetcode id=295 lang=java
 *
 * [295] Find Median from Data Stream
 */

// @lc code=start
class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> leftHeap;
    PriorityQueue<Integer> rightHeap;
    public MedianFinder() {
        this.leftHeap = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });
        this.rightHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        this.leftHeap.offer(num);
        this.rightHeap.offer(this.leftHeap.poll());
        if (this.leftHeap.size() < this.rightHeap.size()) {
            this.leftHeap.offer(this.rightHeap.poll());
        }   
    }
    
    public double findMedian() {
        if (this.leftHeap.size() == this.rightHeap.size()) {
            return leftHeap.peek() + ((double)(rightHeap.peek() - leftHeap.peek())) / 2;
        } else {
            return leftHeap.peek();
        }
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// @lc code=end

