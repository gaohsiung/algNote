import java.util.*;

public class FlattenHashMap {
  
}
class Solution {
  public static HashMap<String, Object> flatten(HashMap<String, Object> json) {
    HashMap<String, Object> res = new HashMap<>();
    for (String key: json.keySet()) {
      StringBuilder sb = new StringBuilder();
      sb.append(key);
      traverse(sb, json.get(key), res);
    }
    return res;
  }
  private static void traverse(StringBuilder prevKey, Object value, HashMap<String, Object> res) {
    if (value instanceof List) { // list
      List<Object> castList = (List) value;
      for (Object o: castList) {
        traverse(prevKey, o, res);
      }
    } else if (value instanceof HashMap) { // map
      HashMap<String, Object> map = (HashMap) value;
      for (String key: map.keySet()) {
        StringBuilder newSb = new StringBuilder();
        newSb.append(prevKey);
        newSb.append(".");
        newSb.append(key);
        traverse(newSb, map.get(key), res);
      }
    } else { // else stuff
      String val = String.valueOf(value);
      res.put(prevKey.toString(), val);
    }
  }


  public static void main(String[] args) {
    HashMap<String, Object> json = new HashMap<>();
    json.put("msg", "Log message");
    HashMap<String, Object> exceptionMap = new HashMap<>();
    exceptionMap.put("cause", "Null pointer");
    List<Object> stackTraceList = new ArrayList<>();
    HashMap<String, Object> stackTraceMap1 = new HashMap<>();
    stackTraceMap1.put("line", 10);
    stackTraceMap1.put("file", "foo.java");
    stackTraceList.add(stackTraceMap1);
    exceptionMap.put("stackTrace", stackTraceList);
    json.put("exception", exceptionMap);


    HashMap<String, Object> res = Solution.flatten(json);
    for (String key: res.keySet()) {
      System.out.println(key+": "+res.get(key));
    }

    // ---------------------------------------------------------------------
    // HashMap<String, Object> map = new HashMap<>();
    // Object ob = map;
    // System.out.println(ob instanceof HashMap);
    // HashMap<String, Object> json = (HashMap) ob;
    // List<Integer> testList = new ArrayList<>();
    // testList.add(1);
    // testList.add(2);
    // testList.add(3);
    // json.put("Test", testList);
    
    // System.out.println(json.get("Test") instanceof ArrayList);
    // List<Object> castList = (List) json.get("Test");
    // for (Object o: castList) {
    //   System.out.println(o);
    

  }
}
