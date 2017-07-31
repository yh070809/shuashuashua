Minimum Subtree 

Given a binary tree, find the subtree with minimum sum. Return the root of the subtree.

 Notice

LintCode will print the subtree which root is your return node.
It s guaranteed that there is only one subtree with minimum sum and the given binary tree is not an empty tree.

Example
Given a binary tree:

     1
   /   \
 -5     2
 / \   /  \
0   2 -4  -5 
return the node 1.


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
 
 思路
这一类的题目都可以这样做：
开一个ResultType的变量result，来储存拥有最小sum的那个node的信息。
然后用分治法来遍历整棵树。
一个小弟找左子数的sum，一个小弟找右子树的sum。
同时，我们根据算出来的当前树的sum决定要不要更新result。
当遍历完整棵树的时候，result里记录的就是拥有最小sum的子树的信息。


class ResultType{
    public TreeNode minSubtree;
    public int sum,minSum;
    public ResultType (TreeNode minSubtree,int minSum, int sum){
        this.minSubtree = minSubtree;
        this.minSum = minSum;
        this.sum = sum;
    }
}
public class Solution {
    /**
     * @param root the root of binary tree
     * @return the root of the minimum subtree
     */
    
    class ResultType {
        TreeNode node;
        int sum;
        public ResultType(TreeNode node, int sum) {
            this.node = node;
            this.sum = sum;
        }
    } 
    
    private ResultType result = null;
    
    public TreeNode findSubtree(TreeNode root) {
        // Write your code here
        if (root == null) {
            return null;
        }
        
        ResultType rootResult = helper(root);
        return result.node;
    }
    
    public ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(null, 0);
        }
        
        ResultType leftResult = helper(root.left);
        ResultType rightResult = helper(root.right);
        ResultType currResult = new ResultType(root, 
                leftResult.sum + rightResult.sum + root.val);
        
        if (result == null || currResult.sum < result.sum) {
            result = currResult;
        }
        
        return currResult;
    }
    
}