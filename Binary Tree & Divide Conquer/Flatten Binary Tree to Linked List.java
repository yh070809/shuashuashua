Flatten Binary Tree to Linked List

Flatten a binary tree to a fake "linked list" in pre-order traversal.

Here we use the right pointer in TreeNode as the next pointer in ListNode.

 Notice

Do not forget to mark the left child of each node to null. Or you will get Time Limit Exceeded or Memory Limit Exceeded.

Example
              1
               \
     1          2
    / \          \
   2   5    =>    3
  / \   \          \
 3   4   6          4
                     \
                      5
                       \
                        6
思路 ： 解法1 ： divide & Conquer : 把左右子树分别flatten。然后把flatten过的左子树接在root的右边。然后从root往右走到底，把flatten过的右子树接上。

Code
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        // write your code here
        
        if (root == null) {
            return;
        }
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        flatten(left);
        flatten(right);
        
        root.left = null;
        root.right = left;
        TreeNode curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }
        curr.right = right;
    }
}


解法二 遍历
最直接的办法是造一颗新的只往右走的树。pre-order遍历输入的树，把一个一个节点都加到新的树的右边去。最后把root接到新的树上。

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    
    private TreeNode dummy; 
     
    public void flatten(TreeNode root) {
        // write your code here
        if (root == null) {
            return;
        }
        
        dummy = new TreeNode(0);
        helper(root);
        root.val = dummy.right.val;
        root.left = null;
        root.right = dummy.right.right;
    }
    
    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        
        TreeNode curr = dummy;
        while (curr.right != null) {
            curr = curr.right;
        }
        curr.right = new TreeNode(root.val);
        
        helper(root.left);
        helper(root.right);
    }
}


