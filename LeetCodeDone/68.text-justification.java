import java.util.*;
/*
 * @lc app=leetcode id=68 lang=java
 *
 * [68] Text Justification
 */

// @lc code=start
class Solution {
  public List<String> fullJustify(String[] words, int maxWidth) {
    // c.c.
    int start = 0;
    List<String> res = new ArrayList<>();
    while (start < words.length) { // [start, end]
      int end = findEnd(words, start, maxWidth);
      res.add(formLine(words, start, end, maxWidth));
      start = end + 1;
    }
    return res;
  }

  private int findEnd(String[] words, int start, int maxWidth) {
    int sentenceLength = 0;
    int ret = words.length - 1;
    for (int i = start; i < words.length; i++) {
      if (i == start) {
        sentenceLength += words[i].length();
        continue;
      }
      if (sentenceLength + 1 + words[i].length() <= maxWidth) {
        sentenceLength = sentenceLength + 1 + words[i].length();
      } else {
        ret = i - 1;
        break;
      }
    }
    return ret;
  }

  private String formLine(String[] words, int start, int end, int maxWidth) {
    StringBuilder sb = new StringBuilder();
    int wordsLength = countWordLength(words, start, end);
    maxWidth = maxWidth - wordsLength;
    if (start != end && end != words.length - 1) { // not last sentence
      int baseSpaceLength = maxWidth / (end - start);
      int remainderSpaceLength = maxWidth % (end - start);
      for (int i = start; i < end; i++) {
        sb.append(words[i]);
        if (remainderSpaceLength > 0) {
          sb = padSpace(sb, baseSpaceLength + 1);
          remainderSpaceLength--;
        } else {
          sb = padSpace(sb, baseSpaceLength);
        }
      }
      sb.append(words[end]);
    } else {
      int spaceLeft = maxWidth;
      for (int i = start; i < end; i++) {
        sb.append(words[i]);
        sb.append(" ");
        spaceLeft = spaceLeft - 1;
      }
      sb.append(words[end]);
      sb = padSpace(sb, spaceLeft);
    }
    return sb.toString();
  }
  private int countWordLength(String[] words, int start, int end) {
    int ret = 0;
    for (int i = start; i <= end; i++) {
      ret += words[i].length();
    }
    return ret;
  }
  private StringBuilder padSpace(StringBuilder sb, int numOfSpaceToPad) {
    while (numOfSpaceToPad-- > 0) {
      sb.append(" ");
    }
    return sb;
  }
  public static void main(String[] args) {
    Solution sol = new Solution();
    for (String s: sol.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16)) {
      System.out.println(s);
    }

  }
}
// @lc code=end
