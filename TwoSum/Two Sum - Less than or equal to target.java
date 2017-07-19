Two Sum - Less than or equal to target

Given an array of integers, find how many pairs in the array such that their sum 
is less than or equal to a specific target number. Please return the number of pairs.


Example
Given nums = [2, 7, 11, 15], target = 24. 
Return 5. 
2 + 7 < 24
2 + 11 < 24
2 + 15 < 24
7 + 11 < 24
7 + 15 < 25

public class Solution {
    /**
     * @param nums an array of integer
     * @param target an integer
     * @return an integer
     */
    public int twoSum5(int[] nums, int target) {
        // handle corner case 
        if (nums == null || nums.length ==0){
            return 0;
        }
        
        Arrays.sort(nums);
        //思路: 双指针， 一个向左，一个向右， 
        //如果 nums[i] + nums [j] <= target;
        //那么 nums [i]+ nums[i]~[j] 之间的任意数一定也小于等于target

        int left = 0;
        int right = nums.length - 1;
        int count = 0;
        
        while (left < right) {
            if (nums[left] + nums[right] <= target) {
                count += right - left;
                left++;
            }
            else {
                right--;
            }
        }
        
        return count;
    }
}