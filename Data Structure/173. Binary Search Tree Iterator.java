173. Binary Search Tree Iterator
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

BSTIterator iterator = new BSTIterator(root);
iterator.next();    // return 3
iterator.next();    // return 7
iterator.hasNext(); // return true
iterator.next();    // return 9
iterator.hasNext(); // return true
iterator.next();    // return 15
iterator.hasNext(); // return true
iterator.next();    // return 20
iterator.hasNext(); // return false
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

// 用一个Stack记录从根节点到当前节点的路径。next的时候就返回Stack最上面的元素。不过拿出最上面的元素后，我们还要看一下这个被返回的元素是否有右节点，如果有的话，就把它的右节点及右节点的所有左边节点都压入栈中。另外，初始化栈时，我们要找到最左边的节点，也就是中序遍历的第一个节点，并把根到第一个节点的路径都压入栈。
// 本题目的本质是二叉树的中序遍历
class BSTIterator {
    private Stack<TreeNode> stk;
    public BSTIterator(TreeNode root) {
        stk = new Stack<>();
        //先找到第一个节点，并把路径压入栈
        while(root != null){
            stk.push(root);
            root = root.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode curr  = stk.pop();
        int res = curr.val;
        
        //如果该元素有右节点，则把它的右节点及右节点所有左节点都压入栈中
        curr = curr.right;
        while(curr != null){
            stk.push(curr);
            curr = curr.left;
        }
        return res;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        //栈为空是不再有下一下个
        return !stk.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */



//二叉树的中序遍历非递归
// public List<Integer> inorderTraversal(TreeNode root) {  
//         List<Integer> list = new ArrayList<>();  
//         if (root == null)  
//             return list;  
//         Stack<TreeNode> stack = new Stack<>();  
//         while (root != null || !stack.isEmpty()) {  
//             if (root != null) {  
//                 stack.push(root);  
//                 root = root.left;  
//             } else {  
//                 root = stack.pop();  
//                 list.add(root.val);  
//                 root = root.right;  
//             }  
//         }  
//         return list;  
//     }