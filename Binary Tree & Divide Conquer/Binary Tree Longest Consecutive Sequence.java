Binary Tree Longest Consecutive Sequence

Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. 
The longest consecutive path need to be from parent to child (cannot be the reverse).

Example
For example,

   1
    \
     3
    / \
   2   4
        \
         5
Longest consecutive sequence path is 3-4-5, so return 3.

   2
    \
     3
    / 
   2    
  / 
 1
Longest consecutive sequence path is 2-3,not3-2-1, so return 2

思路
用分治法遍历整个树。同时维护一个最长序列的变量longest。
遍历每个节点的时候，测试一下加上这个节点的最长序列是多少，决定是否要更新longest。
遍历完整棵树，longest就是我们求的值。


public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    private int longest;
    
    public int longestConsecutive (TreeNode root){
        longest = 0;
        helper(root);
        return longest;
    }
    
    private int helper (TreeNode root){
        if(root == null){
            return 0;
        }
        
        int left = helper(root.left);
        int right  = helper (root.right);
        
        int subtreeLongest = 1;// at least we have root
        if (root.left != null && root.val +1 == root.left.val){
            subtreeLongest = Math.max(subtreeLongest,left+1);
        }
        
        if (root.right != null && root.val +1 == root.right.val){
            subtreeLongest = Math.max(subtreeLongest,right+1);
        }
        
        if (subtreeLongest > longest){
            longest = subtreeLongest;
        }
        
        return subtreeLongest;
    }
}

