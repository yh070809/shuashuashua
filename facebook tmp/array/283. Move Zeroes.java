283. Move Zeroes
Easy

4670

145

Add to List

Share
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.
Accepted
987,212
Submissions
1,692,575


//https://leetcode-cn.com/problems/move-zeroes/solution/yi-dong-ling-by-leetcode-solution/
// 方法一：双指针
// 思路及解法
// 使用双指针，左指针指向当前已经处理好的序列的尾部，右指针指向待处理序列的头部。
// 右指针不断向右移动，每次右指针指向非零数，则将左右指针对应的数交换，同时左指针右移。
// 注意到以下性质：
// 左指针左边均为非零数；
// 右指针左边直到左指针处均为零。
// 因此每次交换，都是将左指针的零与右指针的非零数交换，且非零数的相对顺序并未改变。

class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}

