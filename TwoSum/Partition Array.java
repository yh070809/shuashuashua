Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:

All elements < k are moved to the left
All elements >= k are moved to the right
Return the partitioning index, i.e the first index i nums[i] >= k.

Example
If nums = [3,2,2,1] and k=2, a valid answer is 1.

public class Solution {
    /** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
       
       if (nums == null || nums.length ==0){
           return 0;
       }
       int l =0; 
       int r = nums.length -1;
       
       while (l <=  r){
            while (l <= r && nums[l] < k) {
                l++;
            }
            
        while (l <= r && nums[r] >= k) {
                r--;
            }

           if (l <= r ){
               int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
                r--;
           }
       }
       return l;
    }
}