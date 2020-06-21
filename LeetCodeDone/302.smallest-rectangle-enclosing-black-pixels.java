/*
 * @lc app=leetcode id=302 lang=java
 *
 * [302] Smallest Rectangle Enclosing Black Pixels
 */

// @lc code=start
class Solution {
    public int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0 || 
            image[0] == null || image.length == 0) {
            return -1;
        }
        int rowNum = image.length;
        int colNum = image[0].length;
        int start;
        int end;
        int mid;
        boolean hasOne;
        //top
        int top;
        start = 0;
        end = x;
        while (start <= end) {
            mid = start + (end - start) / 2;
            hasOne = false;
            for (int i = 0; i < colNum; i++) {
                if (image[mid][i] == '1') {
                    hasOne = true;
                    break;
                }
            }
            if (hasOne) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        top = start;
        //bottom
        int bottom;
        start = x;
        end = rowNum - 1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            hasOne = false;
            for (int i = 0; i < colNum; i++) {
                if (image[mid][i] == '1') {
                    hasOne = true;
                    break;
                }
            }
            if (hasOne) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        bottom = end;
        //left
        int left;
        start = 0;
        end = y;
        while (start <= end) {
            mid = start + (end - start) / 2;
            hasOne = false;
            for (int i = 0; i < rowNum; i++) {
                if (image[i][mid] == '1') {
                    hasOne = true;
                    break;
                }
            }
            if (hasOne) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        left = start;
        // right
        int right;
        start = y;
        end = colNum - 1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            hasOne = false;
            for (int i = 0; i < rowNum; i++) {
                if (image[i][mid] == '1') {
                    hasOne = true;
                    break;
                }
            }
            if (hasOne) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        right = end;
        return (right - left + 1) * (bottom - top + 1);

    }



    // public static void main(String[] args) {
    //     Solution s = new Solution();
    //     char[][] image = new char[][] {{'0','0','1','0'},{'0','1','1','0'},{'0','1','0','0'}};
    //     System.out.println(s.minArea(image, 0, 2));
    // }
}
// @lc code=end

