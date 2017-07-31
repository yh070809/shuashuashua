Subsets II 

Given a list of numbers that may has duplicate numbers, return all possible subsets

 Notice

Each element in a subset must be in non-descending order.
The ordering between two subsets is free.
The solution set must not contain duplicate subsets.

Example
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
思路
和Subsets这题差不多，都是套模版。不同的是这题里有重复的问题。
首先还是先排序。输入有序的情况下我们更方便判断重复。
举个例子。如果输入是[1, 21, 22, 23]，上标表示第几个相同的。
如果现在取了[1, 21, 22, 23]。这时候21是startPos - 1对应的。接下来递归是从startPos开始选下一个数。
那么再选的时候只能选[1, 21, 22, 23]而不能选[1, 21, 22, 23]，不能跳着选。
不能选的这个情况，如果num[i] == num[i - 1]并且i != startPos （必须先从 startPos开始选），那么说明跳着选了，我们不采用，continue掉。


class Solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
       ArrayList<ArrayList<Integer>> results = new ArrayList<>();
       if(nums == null) 
            return results;
            
        if (nums.length == 0){
            results.add(new ArrayList<Integer>());
            return results;
        }
        
        Arrays.sort(nums);
        
        ArrayList<Integer> subset = new ArrayList<>();
        helper (nums, 0, subset, results);
        
        return results;
        
    }
    
    public void helper (int [] nums, int startIndex, ArrayList<Integer> subset, ArrayList<ArrayList<Integer>> results){
        results.add(new ArrayList<Integer>(subset));
        for (int i = startIndex; i< nums.length; i++){
            if( i != startIndex && nums [i] == nums[i-1]){
                continue;
            }
            subset.add(nums[i]);
            helper(nums,i+1, subset,results);
            subset.remove(subset.size()-1);
        }
    }
}
