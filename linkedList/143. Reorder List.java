143. Reorder List
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.


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
	public void reorderList(ListNode head) {
		if(head == null || head.next == null) return;
		ListNode l1 = head;
		ListNode mid = findmid(head);
		ListNode l2 = reverse(mid.next);
		mid.next = null;

		while(l2 != null){
			ListNode tmp1 = l1.next;
			ListNode tmp2 = l2.next;
			l1.next = l2;
			l2.next = tmp1;
			l1 = tmp1;
			l2 = tmp2;
		}

	}

	public ListNode findmid (ListNode head){
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}


	public ListNode reverse (ListNode head){
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = null;
		ListNode cur = head;
		ListNode pos = null;

		while(cur != null){
			pos = cur.next;
			cur.next = pre;
			pre = cur;
			cur = pos;
		}
		return pre;
	}
}