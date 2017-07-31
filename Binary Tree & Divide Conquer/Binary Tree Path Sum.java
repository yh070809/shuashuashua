Binary Tree Path Sum

Given a binary tree, find all paths that sum of the nodes in the path equals to a given number target.

A valid path is from root node to any of the leaf nodes.

Example
Given a binary tree, and target = 5:

     1
    / \
   2   4
  / \
 2   3
return

[
  [1, 2, 2],
  [1, 4]
]

思路
DFS + Backtracking
从root往下遍历。如果发现sum == target并且已经走到底了，就把这坨序列加到result里。

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
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        list.add(root.val);
        helper(root, target, result, list, root.val);
        return result;
    }
    
    public void helper(TreeNode root, 
                       int target, 
                       List<List<Integer>> result, 
                       List<Integer> list, 
                       int sum) {
                           
        if (root == null) {
            return;
        }
        
        if (root.left == null && root.right == null && sum == target) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        if (root.left != null) {
            list.add(root.left.val);
            helper(root.left, target, result, list, sum + root.left.val);
            list.remove(list.size() - 1);
        }
        
        if (root.right != null) {
            list.add(root.right.val);
            helper(root.right, target, result, list, sum + root.right.val);
            list.remove(list.size() - 1);
        }
    }
}