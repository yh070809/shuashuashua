Subsets 

Given a set of distinct integers, return all possible subsets.

 Notice

Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.

xample
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

思路
这题套用DFS backtrack的模版。搜索的时候，每层递归开始前把当前遍历到的数字放入subset。递归结束后，这个数字作为备选的所有选择都已经找到了，
所以我们要把这个数字从subset里去掉。这样，下一个数字又可以放进来进行搜索了。

class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        Arrays.sort(nums);
        
        ArrayList<Integer> subset = new ArrayList<Integer>();
        search(nums, subset, result, 0);
        return result;
    }
    
    public void search( int[] nums, 
                        ArrayList<Integer> subset, 
                        ArrayList<ArrayList<Integer>> result, 
                        int startPos) {
                            
        result.add(new ArrayList(subset));
        
        for (int i = startPos; i < nums.length; i++) {
            subset.add(nums[i]);
            search(nums, subset, result, i + 1);
            subset.remove(subset.size() - 1);
        }
        
        return;
    }
}

