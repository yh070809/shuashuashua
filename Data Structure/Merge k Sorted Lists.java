Merge k Sorted Lists

Description
Merge k sorted linked lists and return it as one sorted list.

Analyze and describe its complexity.



Example
Given lists:

[
  2->4->null,
  null,
  -1->null
],
return -1->2->4->null.



思路
建立一个min-heap。把k个链表的表头都扔到heap里。
每次从heap里拿出最小的那个头，放到答案的链表里，然后把拿掉头的那个链表放回heap。
最后heap空了，答案的链表就已经是从小到大建立的了。



Code
/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        
        if (lists == null || lists.size() == 0) {
            return null;
        }
        
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {
            public int compare(ListNode x, ListNode y) {
                return x.val - y.val;
            }
        });
        
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            curr.next = node;
            curr = node;
            node = node.next;
            if (node != null) {
                pq.add(node);
            }
        }
        
        return dummy.next;
    }
}