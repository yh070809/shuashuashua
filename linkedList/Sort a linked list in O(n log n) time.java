Sort a linked list in O(n log n) time using constant space complexity.
Example
Given 1->3->2->null, sort it to 1->2->3->null
题目分析：看到此题，想到一般的数组排序有快排和归并排序。想到用归并排序，常见的数组归并排序，时间，空间复杂度都为o(nlogn)，但是链表不需要重新分配空间，所以可以使用固定空间。排序的时候就想想有没有常见
解决此题的步骤如下：
1.通过快指针（一次进两步）和慢指针（1次进一步）找到链表的中间节点
2. 将指针分为两部分分别进行归并排序
3. 将归并排序后的两组链表进行合并
源代码如下：

/**
 * Definition for ListNode.
 * 
 */ 
public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
     *            using constant space complexity.
     */
     
    public class ListNode {
     int val;
     ListNode next;
     ListNode(int val) {
        this.val = val;
         this.next = null;
     }
 }
    

// 给定链表的head， 返回链表的Mid ,
//两个指针， 一快，一慢，快是慢的两倍。快走到尾时，慢的位置即为mid
private ListNode findMiddle(ListNode head){
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    private ListNode merge (ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        while(head1 != null && head2 != null){
            if(head1.val < head2.val){
                tail.next = head1;
                head1 = head1.next;
            }else{
                tail.next = head2;
                head2 = head2.next;
            }
            
            tail = tail.next;
        }
        
        if (head1 != null){
            tail.next = head1;
        }else{
            tail.next = head2;
        }
        
        return dummy.next;
    }
    
    
    
    public ListNode sortList(ListNode head) {  
       if(head ==null || head.next == null){
           return head;
       }
       
       ListNode mid = findMiddle(head);
       
       ListNode right = sortList(mid.next);
       
       mid.next = null;
       ListNode left = sortList(head);
       
       return merge(left, right);
    }
}
