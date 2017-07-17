/**
*Insert into a Cyclic Sorted List
*  Given a node from a cyclic linked list which has been sorted, write a function to insert a value into the list such that it remains a cyclic sorted list. The given node can be any single node in the list. Return the inserted new node.
* 
*  3->5->1 is a cyclic list, so 3 is next node of 1.
*  3->5->1 is same with 5->1->3
*
* Example
*   Given a list, and insert a value 4:
*   3->5->1
*
*       思路
* 这道题就是要把所有的case都想清楚。
* 1：如果node就是null，需要造一个新的node，并且自己和自己连上。
* 除去以上的case，我们需要在这个链表里找到需要插入的点的位置。我们遍历链表，并且进行不同case的分析。
* 2：如果node.val < node.next.val，那么如果x在这里两个值当中，我们就可以把x插进去。
* 3：如果node.val > node.next.val，这说明现在我们在链表的环的最后一个节点。那么如果x比整个链表中最大的节点值node.val还大，或者比整个链表中最小的节点值node.next.val还小，那么x可以插在这两个当中。
* 4：如果node.val == node.next.val，那么我们还是要判断一下node是不是就是环的最后一个节点，以及node.next是不是环的头。如果是这样，我们可以把x插进去。
*
*/
//Definition for ListNode


public class InsertIntoCyclicSortedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    /**
     * @param node a list node in the list
     * @param x an integer
     * @return the inserted new list node
     */
    public ListNode insert (ListNode node, int x){
        //如果node为null,那么new 一个node，并且自己和自己相连；
        if (node == null){
            node = new ListNode(x);
            node.next = node;
            return node;
        }
        ListNode head = node;
        while (node != null && node.next != null){
            if (node.val < node.next.val){
                if(x >=  node.val && x <= node.next.val){
                    insertNode(node,x);
                    break;
                }
            }else if (node.val > node.next.val) {
                if(x > node.val || x < node.next.val){
                    insertNode(node,x);
                    break;
                }
            }else { // node.val == node.next.val
                if (node.next == head){
                    insertNode(node,x);
                    break;
                }
            }
            node = node.next;
        }
        return head;
    }
    public void insertNode (ListNode node, int x){
        ListNode newNode = new ListNode (x);
        newNode.next = node.next;
        node.next = newNode;
    }
}

