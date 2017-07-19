Given an array of integers, remove the duplicate numbers in it.

You should:
1. Do it in place in the array.
2. Move the unique numbers to the front of the array.
3. Return the total number of the unique numbers.


/*
Example
Given nums = [1,3,1,4,4,2], you should:

Move duplicate integers to the tail of nums => nums = [1,3,4,2,?,?].
Return the number of unique integers in nums => 4.
Actually we don't care about what you place in ?, we only care about the part which has no duplicate integers.

**/

思路 ： 快慢指针问题：
O(nlogn)时间，O(1)空间：首先对数组排序，然后用快慢指针解决，快慢指针在同一起点，
因为已经排序所以重复数字会排在一起，所以快指针一个个读取数字，每当读到与慢指针不同的数字，
慢指针首先往后走一格（保存之前的数），然后再把快指针所在的数放到慢指针的位置（获得到新的数）。
不停重复这个过程直到快指针走完数组。慢指针所在的位置就是最后一个unique number的位置。


public class Solution {
    /**
     * @param nums an array of integers
     * @return the number of unique integers
     */
    public int deduplication(int[] nums) {
        
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        
        int index =0;
        for(int i =1; i < nums.length; i++){
            if(nums[i] != nums [index]){
                nums[++ index] = nums[i];
            }
        }
        
        return index+1;
    }
}