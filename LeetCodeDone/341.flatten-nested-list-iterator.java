import java.util.*;

/*
 * @lc app=leetcode id=341 lang=java
 *
 * [341] Flatten Nested List Iterator
 */

// @lc code=start
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
// interface NestedInteger {
//     // @return true if this NestedInteger holds a single integer, rather than a nested list.
//     public boolean isInteger();
//     // @return the single integer that this NestedInteger holds, if it holds a single integer
//     // Return null if this NestedInteger holds a nested list
//     public Integer getInteger();
//     // @return the nested list that this NestedInteger holds, if it holds a nested list
//     // Return null if this NestedInteger holds a single integer
//     public List<NestedInteger> getList();
// }
public class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> helperStack;
    public NestedIterator(List<NestedInteger> nestedList) {
        this.helperStack = new Stack<>();
        addToStack(nestedList);
    }

    @Override
    public Integer next() {
        while(!this.helperStack.isEmpty() && !this.helperStack.peek().isInteger()) {
            NestedInteger cur = this.helperStack.pop();
            addToStack(cur.getList());
        }
        if (this.helperStack.isEmpty()) return null;

        return this.helperStack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!this.helperStack.isEmpty() && !this.helperStack.peek().isInteger()) {
            NestedInteger cur = this.helperStack.pop();
            addToStack(cur.getList());
        }
        return !this.helperStack.isEmpty();
    }

    private void addToStack(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) return;
        for(int i = nestedList.size() - 1; i >= 0; i--) {
            this.helperStack.push(nestedList.get(i));
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
// @lc code=end

