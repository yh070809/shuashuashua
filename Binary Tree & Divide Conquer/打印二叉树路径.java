打印二叉树路径
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]

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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
  			List<List<Integer>> pathlist =  new List<List<Integer>>();
            if (root == null){
               return pathlist;
            }
            Stack<Integer> stack = new Stack<Integer>();
            FindPath (root , sum , stack, pathlist);
            return pathlist;
	}
  	
      //先序遍历，动态保存根节点到当前节点的path
  
    private void FindPath (TreeNode root, int sum, Stack <Integer> path, List<List<Integer>> pathlist){    
            if(! root ) return;
            if(root.left == null && root.right == null){
            	if(root.val == sum) {
				List<Integer> list = new List<Integer>();
                for (int i: path ){
                  list.add(new Integer(i));
                }
                list.add(new Integer(root.val));
                pathlist.add(list);
                
              }
    
    	  }else{
        	 path.push(new Integer(root.val));
             FindPath(root.left, sum - root.val, path, pathlist);
             FindPath(root.right, sum - root.val, path, pathlist);
        	 path.pop();
        
          }                
		
        }        
    }
