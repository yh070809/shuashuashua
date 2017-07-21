Two Sum - Closest to target

Given an array nums of n integers, find two integers in nums such that the sum is closest to a given number, target.

Return the difference between the sum of the two integers and the target.

Example
Given array nums = [-1, 2, 1, -4], and target = 4.

The minimum difference is 1. (4 - (2 + 1) = 1).


        思路
这个套路的题就是先排序。
排完从两边往当中走。
当我们发现sum < target，说明要再大一点会更接近target。那么往右走。
反之当sum > target，说明要再小一点会更接近target。那么往左走

public class Solution {
    /**
     * @param nums an integer array
     * @param target an integer
     * @return the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        // handle corner case 
        if (nums == null || nums.length < 2){
            return -1;
        }
        
        //这种题的套路就是先排序
        Arrays.sort(nums);
        
        //而后两个指针往中间走
        
        int min = Integer.MAX_VALUE;
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                min = Math.min(min, target - nums[left] - nums[right]);
                left++;
            }
            else {
                min = Math.min(min, nums[left] + nums[right] - target);
                right--;
            }
        }
        
        return min;
    }
}