public class CheckLinkedListIsPalindrome {
  
}
class Solution {
  private static class ListNode {
    int val;
    ListNode next;
    private ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
  private static ListNode cur;
  public static boolean isPalindrome(ListNode head) {
    cur = head;
    return recursionCheck(head);
  }
  private static boolean recursionCheck(ListNode node) {
    if (node != null) {
      if (!recursionCheck(node.next)) return false;
      if (node.val != cur.val) return false;
      cur = cur.next;
    }
    return true;
  }
  public static void main(String[] args) {
    // ListNode l5 = new ListNode(1, null);
    ListNode l4 = new ListNode(1, null);
    ListNode l3 = new ListNode(2, l4);
    ListNode l2 = new ListNode(3, l3);
    ListNode l1 = new ListNode(1, l2);
    System.out.println(isPalindrome(l1));
  }
}
