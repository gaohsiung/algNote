import java.util.*;

/*
 * @lc app=leetcode id=284 lang=java
 *
 * [284] Peeking Iterator
 */

// @lc code=start
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
	Iterator<Integer> iterator;
	Integer cur;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
		this.iterator = iterator;
		this.cur = iterator.next();
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		return this.cur;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		int ret = this.cur;
		if (iterator.hasNext()) {
			this.cur = iterator.next();
		} else {
			this.cur = null;
		}
		return ret;
	    
	}
	
	@Override
	public boolean hasNext() {
	    return this.cur != null;
	}
}
// @lc code=end

