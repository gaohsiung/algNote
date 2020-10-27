import java.util.List;

/*
 * @lc app=leetcode id=707 lang=java
 *
 * [707] Design Linked List
 */

// @lc code=start
class MyLinkedList {

  private class ListNode {
    int val;
    ListNode prev;
    ListNode next;
    private ListNode(int val) {
      this.val = val;
      this.prev = null;
      this.next = null;
    }
  }
  /** Initialize your data structure here. */
  private ListNode head;
  private ListNode tail;
  private int size;
  public MyLinkedList() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  /**
   * Get the value of the index-th node in the linked list. If the index is
   * invalid, return -1.
   */
  public int get(int index) {
    if (index < 0 || index >= this.size) {
      // throw new IllegalArgumentException();
      return -1;
    }
    ListNode node = this.head;
    while(index-- > 0) {
      node = node.next;
    }
    return node.val;
  }

  /**
   * Add a node of value val before the first element of the linked list. After
   * the insertion, the new node will be the first node of the linked list.
   */
  public void addAtHead(int val) {
    ListNode newNode = new ListNode(val);
    if (this.size == 0) {
      this.head = newNode;
      this.tail = newNode;
    } else {
      newNode.next = this.head;
      this.head.prev = newNode;
      this.head = newNode;
    }
    size++;
  }

  /** Append a node of value val to the last element of the linked list. */
  public void addAtTail(int val) {
    ListNode newNode = new ListNode(val);
    if (this.size == 0) {
      this.head = newNode;
      this.tail = newNode;
    } else {
      newNode.prev = this.tail;
      this.tail.next = newNode;
      this.tail = newNode;
    }
    size++;
  }

  /**
   * Add a node of value val before the index-th node in the linked list. If index
   * equals to the length of linked list, the node will be appended to the end of
   * linked list. If index is greater than the length, the node will not be
   * inserted.
   */
  public void addAtIndex(int index, int val) {
    if (index == 0) {
      addAtHead(val);
      return;
    }
    if (index == this.size) {
      addAtTail(val);
      return;
    }
    if (index < 0 || index > this.size) {
      return;
    }
    ListNode beforeThisNode = this.head;
    while(index-- > 0) {
      beforeThisNode = beforeThisNode.next;
    }
    ListNode insertedNode = new ListNode(val);
    beforeThisNode.prev.next = insertedNode;
    insertedNode.prev = beforeThisNode.prev;
    insertedNode.next = beforeThisNode;
    beforeThisNode.prev = insertedNode;
    this.size++;
  }

  /** Delete the index-th node in the linked list, if the index is valid. */
  public void deleteAtIndex(int index) {
    if (index < 0 || index >= this.size) {
      // throw new IllegalArgumentException();
      return;
    } else if (this.size == 1){
      this.head = null;
      this.tail = null;
    } else if (index == 0) {
      this.head.next.prev = null;
      this.head = this.head.next;
    } else if (index == this.size - 1) {
      this.tail.prev.next = null;
      this.tail = this.tail.prev;
    } else {
      ListNode node = this.head;
      while(index-- > 0) {
        node = node.next;
      }
      node.prev.next = node.next;
      node.next.prev = node.prev;
    }
    this.size--;
    return;
  }
  public static void main(String[] args) {
    MyLinkedList mylist = new MyLinkedList();
    mylist.addAtHead(2);
    mylist.deleteAtIndex(1);
    mylist.addAtHead(2);
    mylist.addAtHead(7);
    mylist.addAtHead(3);
    mylist.addAtHead(2);
    mylist.addAtHead(5);
    mylist.addAtHead(5);
    mylist.get(5);
    mylist.deleteAtIndex(6);
    mylist.deleteAtIndex(4);
  }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList(); int param_1 = obj.get(index);
 * obj.addAtHead(val); obj.addAtTail(val); obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
// @lc code=end
