669. Trim a Binary Search Tree
Easy

2157

196

Add to List

Share
Given the root of a binary search tree and the lowest and highest boundaries as low and high, trim the tree so that all its elements lies in [low, high]. Trimming the tree should not change the relative structure of the elements that will remain in the tree (i.e., any node's descendant should remain a descendant). It can be proven that there is a unique answer.

Return the root of the trimmed binary search tree. Note that the root may change depending on the given bounds.

 

Example 1:


Input: root = [1,0,2], low = 1, high = 2
Output: [1,null,2]
Example 2:


Input: root = [3,0,4,null,2,null,null,1], low = 1, high = 3
Output: [3,2,null,1]
Example 3:

Input: root = [1], low = 1, high = 2
Output: [1]
Example 4:

Input: root = [1,null,2], low = 1, high = 3
Output: [1,null,2]
Example 5:

Input: root = [1,null,2], low = 2, high = 4
Output: [2]
 

Constraints:

The number of nodes in the tree in the range [1, 104].
0 <= Node.val <= 104
The value of each node in the tree is unique.
root is guaranteed to be a valid binary search tree.
0 <= low <= high <= 104
Accepted
118,425
Submissions
187,404


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

// 当 \text{node.val > R}node.val > R，那么修剪后的二叉树必定出现在节点的左边。

// 类似地，当 \text{node.val < L}node.val < L，那么修剪后的二叉树出现在节点的右边。否则，我们将会修剪树的两边。


//链接：https://leetcode-cn.com/problems/trim-a-binary-search-tree/solution/xiu-jian-er-cha-sou-suo-shu-by-leetcode/

class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return root;
        if (root.val > R) return trimBST(root.left, L, R);
        if (root.val < L) return trimBST(root.right, L, R);

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}

