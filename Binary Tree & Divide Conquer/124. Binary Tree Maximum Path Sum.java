124. Binary Tree Maximum Path Sum
Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any node sequence from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

 

Example 1:


Input: root = [1,2,3]
Output: 6
Example 2:


Input: root = [-10,9,20,null,null,15,7]
Output: 42


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        maxSub(root);
        return maxSum;
    }
    
    public int maxSub(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftSum = maxSub(root.left);
        int rightSum = maxSub(root.right);
        int maxReturn = Math.max(Math.max(leftSum + root.val, rightSum + root.val), root.val);
       maxSum = Math.max(Math.max(maxSum, leftSum + root.val + rightSum), maxReturn);
        return maxReturn;
    }
}