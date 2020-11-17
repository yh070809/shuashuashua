Given the head of a linked list, return the list after sorting it in ascending order.

Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?


Example 1:


Input: head = [4,2,1,3]
Output: [1,2,3,4]
Example 2:


Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
Example 3:

Input: head = []
Output: []



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
    public ListNode sortList(ListNode head) {
        int step = 1;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        int size = length(head);
        while (step < size) {
            dummyHead.next = splitAndMergeK(dummyHead.next, step);
            step *= 2;
        }
        return dummyHead.next;
    }
    
    public ListNode splitAndMergeK(ListNode head , int k){
        // iterative merge for every 2 size K segment;
        ListNode dummyhead = new ListNode(0);
        ListNode cur = dummyhead;
        while(head != null){
          ListNode[] headTail1 = getK(head, k);
            // Get a segment of size K
            head = headTail1[1].next;
            headTail1[1].next = null;
            if (head == null) {
                cur.next = headTail1[0];
                return dummyhead.next;
            }
            ListNode[] headTail2 = getK(head, k); 
            
            // Get another segment of size K
            head = headTail2[1].next;
            headTail2[1].next = null;
            //merge two segments
            ListNode[] mergedHeadTail =  mergeK(headTail1[0],headTail2[0]); 
            cur.next = mergedHeadTail[0]; // hook up
            cur = mergedHeadTail[1];
            
        }
        return dummyhead.next;
        
    }
    
      private ListNode[] getK(ListNode head, int K) { 
        // get a segment of size K
        ListNode[] ans = new ListNode[2]; //head must not be null;
        ans[0] = head;
        for (int i = 0; i < K; i++) {
            ans[1] = head;
            head = head.next;
            if (head == null) break;
        }
        return ans;
    }
    
    // public ListNode getK (ListNode head , int k){
    //     ListNode dummy = new ListNode(-1);
    //     ListNode cur;
    //     dummy.next = head;
    //     cur = dummy;
    //     for (int i =0 ; i< k ;i++){
    //         cur.next =head;
    //         head = head.next;
    //         cur = cur.next;
    //         if(head == null) break;
    //     }
    //     return cur; 
    // }
    
    public int length(ListNode head){
        int length = 0;
        if(head == null){
            return 0;
        }
        while( head != null){
            head = head.next;
            length++;
        }
        return length;  
    }
    
    // public ListNode merge (ListNode l1, ListNode l2){
    //     ListNode dummy = new ListNode(-1);
    //     ListNode cur;
    //     cur= dummy;
    //     while(l1 != null && l2 != null){
    //         if(l1.val < l2.val){
    //             cur.next =l1;
    //             l1 = l1.next;
    //         }else{
    //             cur.next =l2;
    //             l2 = l2.next;
    //         }
    //         cur = cur.next;
    //     }
    //     cur.next = (l1 !=null) ? l1: l2;
    //     return dummy.next;
    // }
    private ListNode[] mergeK(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
            cur.next = null;
        }
        cur.next = head1 != null ? head1 : head2;
        while (cur.next != null) {
            cur = cur.next;
        }
        return new ListNode[]{dummyHead.next, cur};
    }
    
    
}


