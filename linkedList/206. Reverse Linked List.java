206. Reverse Linked List

Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr != null){
            ListNode nxtTmp  = curr.next;
            curr.next = prev;
            prev= curr;
            curr = nxtTmp;
        }
        
        return prev;
        
        
    }
}


private ListNode reverseList(ListNode head){
    
    if(head == null || head.next == null){
       return head;
    }
	ListNode cur = head;
    ListNode front = null;
    ListNode behind = null;
    while(cur != null){
      behind = cur.next;
      cur.next = front;
      front = cur;
      cur = behind;
      /***如果有环****/
      // if (behind == head){
      // 	break;
      // }
    }
  return front;
  
}