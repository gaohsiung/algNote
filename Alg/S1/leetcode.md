# L278
```java
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        // if (n <= 0) throw new Exception;
        // if (isBadVersion(n)) throw new IllegalArgumentException();
        
        int left = 0;
        int right = n;
        int mid;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (!isBadVersion(mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return isBadVersion(left)? left:right;
    }
}
```
# L374
```java
/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) > 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return guess(left) == 0? left:right;
    }
}
```
# L35
```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) throw new IllegalArgumentException();
        
        int left = 0;
        int right = nums.length;
        int mid;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return nums[left] >= target? left:right;
    }
}
```
# L34
```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }
        
        int left = 0;
        int right = nums.length - 1;
        
        if (nums[left] > target || nums[right] < target) {
            return new int[] {-1, -1};
        }
        
        int mid;
        while (left + 1 < right) {
            mid = left + (right- left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        int first;
        if (nums[left] == target) {
            first = left;
        } else if (nums[right] == target) {
            first = right;
        } else {
            first = -1;
        }
        
        left = 0;
        right = nums.length - 1;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        int last;
        if (nums[right] == target) {
            last = right;
        } else if (nums[left] == target) {
            last = left;
        } else {
            last = -1;
        }
        return new int[] {first, last};
    }
}
```
# L162
```java
class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) throw new IllegalArgumentException();
        
        int left = 0;
        int right = nums.length - 1;
        int mid;
        int prev;
        int next;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            prev = Math.max(left, mid - 1);
            next = Math.min(right, mid + 1);
            if (nums[mid] > nums[prev] && nums[mid] > nums[next]) {
                return mid;
            } else if (nums[mid] > nums[prev]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return nums[left] > nums[right]? left:right;
    }
}


// [1,2,3]
```
# L240
```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || 
            matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        int row = rowNum - 1;
        int col = 0;
        int cur;
        while (row >= 0 && col < colNum) {
            cur = matrix[row][col];
            if (cur == target) {
                return true;
            } else if (cur > target) {
                row -= 1;
            } else {
                col += 1;
            }
        }
        return false;
    }
}
```
# L74
```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 ||
            matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        int left = 0;
        int right = rowNum * colNum - 1;
        int mid;
        int cur;
        while (left <= right) {
            mid = left + (right - left) / 2;
            cur = matrix[mid/colNum][mid%colNum];
            if (cur == target) {
                return true;
            } else if (cur > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
```
# L69
注意int 越界问题
```java
class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        
        int left = 1;
        int right = x;
        long mid;
        while (left + 1 < right) {
            mid = (long) left + (right - left) / 2;
            if (mid*mid == x) {
                return (int) mid;
            } else if (mid*mid > x) {
                right = (int) mid;
            } else {
                left = (int) mid;
            }
        }
        return left;
    }
}
```


