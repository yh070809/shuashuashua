938. Range Sum of BST
Easy

1842

268

Add to List

Share
Given the root node of a binary search tree, return the sum of values of all nodes with a value in the range [low, high].

 

Example 1:


Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
Output: 32
Example 2:


Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
Output: 23
 

Constraints:

The number of nodes in the tree is in the range [1, 2 * 104].
1 <= Node.val <= 105
1 <= low <= high <= 105
All Node.val are unique.
Accepted
304,589
Submissions
368,374


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

// 我们对树进行深度优先搜索，对于当前节点 node，如果 node.val 小于等于 L，那么只需要继续搜索它的右子树；如果 node.val 大于等于 R，那么只需要继续搜索它的左子树；如果 node.val 在区间 (L, R) 中，则需要搜索它的所有子树。

// 我们在代码中用递归和迭代的方法分别实现了深度优先搜索。


class Solution {
    int ans;
    public int rangeSumBST(TreeNode root, int L, int R) {
        ans = 0;
        dfs(root, L, R);
        return ans;
    }

    public void dfs(TreeNode node, int L, int R) {
        if (node != null) {
            if (L <= node.val && node.val <= R)
                ans += node.val;
            if (L < node.val)
                dfs(node.left, L, R);
            if (node.val < R)
                dfs(node.right, L, R);
        }
    }
}


// 作者：LeetCode
// 链接：https://leetcode-cn.com/problems/range-sum-of-bst/solution/er-cha-sou-suo-shu-de-fan-wei-he-by-leetcode/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。