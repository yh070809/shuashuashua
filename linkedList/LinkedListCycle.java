//Linked List Cycle
//Given a linked list, determine if it has a cycle in it.
//Given -21->10->4->5, tail connects to node index 1, return true

/**
 * Definition for ListNode.
 * 
 */ 
//思路是两个指针，一个走的快一个走的慢，循环下去，只要两者能够重逢说明有环。
//官方解答想的是两者不重合就一直走。

public class ListNode {
     int val;
     ListNode next;
      ListNode(int val) {
          this.val = val;
         this.next = null;
      }
  }
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {  
        if(head == null || head.next == null){
            return false;
        }
        
        ListNode fast,slow;
        fast = head.next;
        slow = head;
        while( fast != slow){
            if(fast == null || fast.next == null)
                return false;
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return true;
    }
}

 
