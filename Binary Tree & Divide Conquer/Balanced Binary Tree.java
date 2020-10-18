Balanced Binary Tree
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example
Given binary tree A = {3,9,20,#,#,15,7}, B = {3,#,20,15,7}

A)  3            B)    3 
   / \                  \
  9  20                 20
    /  \                / \
   15   7              15  7
The binary tree A is a height-balanced binary tree, but B is not.

思路
分治的思想。
如果一个二叉树是平衡的。那么root的左子树和右子树一定是平衡的。
并且左子树和右子树高度差是小于等于1的。

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
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }
        
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        
        return isBalanced(root.left) && isBalanced(root.right) 
                && Math.abs(leftHeight - rightHeight) <= 1;
    }
    
    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
/******自顶向下的话会时间复杂度是O n2， 但是自底向顶的话时间复杂度是O(n)*****/
//自底向上递归的做法类似于后序遍历，对于当前遍历到的节点，先递归地判断其左右子树是否平衡，
//再判断以当前节点为根的子树是否平衡。如果一棵子树是平衡的，则返回其高度（高度一定是非负整数），
//否则返回 -1−1。如果存在一棵子树不平衡，则整个二叉树一定不平衡。


class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}

                高度    深度     层数
     3           3       0       1
   /   \                 
  9    20        2       1       2
 / \  /               
6  15 7          1       2       3
   /  \
   17  23        0       3       4

   结点的高度：结点到叶子结点的最长路径
   结点的深度：根节点到该结点的边的个数
   树的高度： 根节点的高度
   结点的层数：结点的深度 + 1