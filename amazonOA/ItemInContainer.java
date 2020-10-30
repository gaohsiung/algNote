import java.util.*;

class ItemInContainer {
  public static List<Integer> numberOfItems(String s, List<Integer> start, List<Integer> end) {
    NavigableMap<Integer, Integer> treeMap = new TreeMap<>();

    int countSoFar = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '|') {
        treeMap.put(i, countSoFar);
      } else {
        countSoFar++;
      }
    }
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < start.size(); i++) {
      list.add(number(treeMap, start.get(i) - 1, end.get(i) - 1));
    }
    return list;
  }

  static int number(NavigableMap<Integer, Integer> treemap, int start, int end) {
    if (treemap.floorEntry(end) == null || treemap.ceilingEntry(start) == null)
      return 0;
    int i = treemap.floorEntry(end).getValue() - treemap.ceilingEntry(start).getValue();
    return Math.max(i, 0);
  }
}
// O(n log n + m log n) [n times insertion and m times search] 
// where n = length of String s and m = length of start list.