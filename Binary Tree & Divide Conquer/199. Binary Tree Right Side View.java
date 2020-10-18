199. Binary Tree Right Side View
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---

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
public List<Integer> rightSideView(TreeNode root) {
        if(root==null)return new ArrayList<>();
        
        Queue<TreeNode>queue = new LinkedList<>();
        queue.add(root);
        List<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty())
        {
            int size = queue.size();
            boolean isFirstFromRight = true;
            for(int i=0;i<size;i++)
            {
                TreeNode node = queue.remove();
                if(isFirstFromRight)ans.add(node.val);
                isFirstFromRight = false; // mark the remaining nodes in the same level as NOT the first seen Node from right
                
                if(node.right!=null)queue.add(node.right); //adding right child first, so that for all levels, first Node will be first seen Node from right
                if(node.left!=null)queue.add(node.left);  //then adding left child
            }
        }
        return ans;
    }
        
}