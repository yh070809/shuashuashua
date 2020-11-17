449. Serialize and Deserialize BST
Serialization is converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You need to ensure that a binary search tree can be serialized to a string, and this string can be deserialized to the original tree structure.

The encoded string should be as compact as possible.

Example 1:

Input: root = [2,1,3]
Output: [2,1,3]
Example 2:

Input: root = []
Output: []
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

  // 将BST序列化为字符串
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
   
    // 前序遍历，遇到空节点不添加null
    public void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val).append(",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // 将字符串反序列化为BST
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        // 将字符串转为队列
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
   
    public TreeNode deserialize(Queue<String> q, int lower, int upper) {
        // 队列为空，说明树已经构造完毕，递归结束
        if (q.isEmpty()) return null;
       
        // 取队首元素的值
        String s = q.peek();
        int val = Integer.parseInt(s);

        // 如果值不在范围中，说明这个位置应该为空，结束本层递归
        if (val < lower || val > upper) return null;
       
        // 如果值在范围中，将其出队，用值构造树
        q.poll();
        TreeNode root = new TreeNode(val);

        // 将root值作为上界，构造左子树
        root.left = deserialize(q, lower, val);
        // 将root值作为下界，构造右子树
        root.right = deserialize(q, val, upper);
       
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;