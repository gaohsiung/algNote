// import java.util.*;
// /*
//  * @lc app=leetcode id=432 lang=java
//  *
//  * [432] All O`one Data Structure
//  */

// // @lc code=start
// class AllOne {

//   /** Initialize your data structure here. */
//   private static class Bucket {
//     int value;
//     Set<String> keys;
//     Bucket prev;
//     Bucket next;
//     private Bucket(int value) {
//       this.value = value;
//       keys = new HashSet<>();
//       this.prev = null;
//       this.next = null;
//     }
//   }
//   Map<String, Integer> keyToValue;
//   Map<Integer, Bucket> valueToBucket;
//   private Bucket head;
//   private Bucket tail;
//   public AllOne() {
//     this.keyToValue = new HashMap<>();
//     this.valueToBucket = new HashMap<>();
//     this.head = new Bucket(Integer.MIN_VALUE);
//     this.tail = new Bucket(Integer.MAX_VALUE);
//     this.head.next = tail;
//     this.tail.prev = head;
//   }

//   /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
//   public void inc(String key) {
//     if (keyToValue.containsKey(key)) {
//       updateKey(key, 1);
//       return;
//     }
//     keyToValue.put(key, 1);
//     Bucket newBucket;
//     if (!valueToBucket.containsKey(1)) {
//       newBucket = new Bucket(1);
//       newBucket.prev = this.head;
//       newBucket.next = this.head.next;
//       this.head.next.prev = newBucket;
//       this.head.next = newBucket;
//       valueToBucket.put(1, newBucket);
//     } else {
//       newBucket = valueToBucket.get(1);
//     }
//     newBucket.keys.add(key);
//   }

//   /**
//    * Decrements an existing key by 1. If Key's value is 1, remove it from the data
//    * structure.
//    */
//   public void dec(String key) {
//     if (keyToValue.containsKey(key)) {
//       updateKey(key, -1);
//     }
//   }

//   /** Returns one of the keys with maximal value. */
//   public String getMaxKey() {
//     return tail.prev == head?"":tail.prev.keys.iterator().next();
//   }

//   /** Returns one of the keys with Minimal value. */
//   public String getMinKey() {
//     return tail.prev == head?"":head.next.keys.iterator().next();
//   }
//   private void updateKey(String key, int offset) {
//     int oldValue = this.keyToValue.get(key);
//     int newValue = oldValue + offset;
//     Bucket curBucket = this.valueToBucket.get(oldValue); 
//     Bucket smallerBucket = curBucket.prev;
//     Bucket biggerBucket = curBucket.next;
//     // remove old
//     if (curBucket.keys.size() == 1) {
//       curBucket.prev.next = curBucket.next;
//       curBucket.next.prev = curBucket.prev;
//       curBucket.prev = null;
//       curBucket.next = null;
//     } else {
//       this.valueToBucket.get(oldValue).keys.remove(key);
//     }
//     // add to new
//     if (newValue == 0) { // no need to add
//       this.keyToValue.remove(key);
//     } else {
//       this.keyToValue.put(key, newValue);
//       if (valueToBucket.containsKey(newValue)) {
//         valueToBucket.get(newValue).keys.add(key);
//       } else { // add new bucket
//         Bucket newBucket = new Bucket(newValue);
//         newBucket.keys.add(key);
//         if (offset > 0) {
//           newBucket.prev = biggerBucket.prev;
//           newBucket.next = biggerBucket;
//           biggerBucket.prev.next = newBucket;
//           biggerBucket.prev = newBucket;
//         } else {
//           newBucket.prev = smallerBucket;
//           newBucket.next = smallerBucket.next;
//           smallerBucket.next.prev = newBucket;
//           smallerBucket.next = newBucket;
//         }
//       }
//     }

//   }
//   public static void main(String[] args) {
    
//   }
// }

// /**
//  * Your AllOne object will be instantiated and called as such: AllOne obj = new
//  * AllOne(); obj.inc(key); obj.dec(key); String param_3 = obj.getMaxKey();
//  * String param_4 = obj.getMinKey();
//  */
// // @lc code=end
