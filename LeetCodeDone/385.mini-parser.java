import java.util.*;

/*
 * @lc app=leetcode id=385 lang=java
 *
 * [385] Mini Parser
 */

// @lc code=start
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
// public interface NestedInteger {
//     // Constructor initializes an empty nested list.
//     public NestedInteger();

//     // Constructor initializes a single integer.
//     public NestedInteger(int value);

//     // @return true if this NestedInteger holds a single integer, rather than a nested list.
//     public boolean isInteger();

//     // @return the single integer that this NestedInteger holds, if it holds a single integer
//     // Return null if this NestedInteger holds a nested list
//     public Integer getInteger();

//     // Set this NestedInteger to hold a single integer.
//     public void setInteger(int value);

//     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
//     public void add(NestedInteger ni);

//     // @return the nested list that this NestedInteger holds, if it holds a nested list
//     // Return null if this NestedInteger holds a single integer
//     public List<NestedInteger> getList();
// }
class Solution {
    public NestedInteger deserialize(String s) {
        // c.c.
        
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }
        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger root = new NestedInteger();
        stack.push(root); // idx 0 is [
        int i = 1;
        while(i < s.length()) {
            if (s.charAt(i) == '[') {
                NestedInteger ni = new NestedInteger();
                stack.peek().add(ni);
                stack.push(ni);
                i++;
            } else if (s.charAt(i) == ']') {
                stack.pop();
                i++;
            } else if((s.charAt(i) >= '0' && s.charAt(i) <= '9') || s.charAt(i) == '-' ) {
                int sign = 1;
                if (s.charAt(i) == '-') {
                    sign = -1;
                    i++;
                }
                int val = 0;
                while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    val = val*10 + (s.charAt(i) - '0');
                    i++;
                }
                stack.peek().add(new NestedInteger(val*sign));
            } else { // \0 or ,
                i++;
            }
        }
        return root;
    }
}
// @lc code=end

