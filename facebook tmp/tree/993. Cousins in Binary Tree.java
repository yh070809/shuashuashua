993. Cousins in Binary Tree
Easy

1183

63

Add to List

Share
In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.

 

Example 1:


Input: root = [1,2,3,4], x = 4, y = 3
Output: false
Example 2:


Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
Example 3:



Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
 

Constraints:

The number of nodes in the tree will be between 2 and 100.
Each node has a unique integer value from 1 to 100.
Accepted
127,418
Submissions
244,495

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

// 当且仅当一对节点深度相同而父节点不相同时，它们是堂兄弟节点。一种非常直接的方法就是通过某种方法求出每一个节点的深度与父节点。

// 算法

// 我们用深度优先搜索标记每一个节点，对于每一个节点 node，它的父亲为 par，深度为 d，我们将其记录到 Hashmap 中：parent[node.val] = par 且 depth[node.val] = d。


class Solution {
    Map<Integer, Integer> depth;
    Map<Integer, TreeNode> parent;

    public boolean isCousins(TreeNode root, int x, int y) {
        depth = new HashMap();
        parent = new HashMap();
        dfs(root, null);
        return (depth.get(x) == depth.get(y) && parent.get(x) != parent.get(y));
    }

    public void dfs(TreeNode node, TreeNode par) {
        if (node != null) {
            depth.put(node.val, par != null ? 1 + depth.get(par.val) : 0);
            parent.put(node.val, par);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }
}


//链接：https://leetcode-cn.com/problems/cousins-in-binary-tree/solution/er-cha-shu-de-tang-xiong-di-jie-dian-by-leetcode/
