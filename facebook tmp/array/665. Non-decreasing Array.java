665. Non-decreasing Array
Easy

2310

553

Add to List

Share
Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.

We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).

 

Example 1:

Input: nums = [4,2,3]
Output: true
Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
Example 2:

Input: nums = [4,2,1]
Output: false
Explanation: You can't get a non-decreasing array by modify at most one element.
 

Constraints:

1 <= n <= 10 ^ 4
- 10 ^ 5 <= nums[i] <= 10 ^ 5
Accepted
113,134
Submissions
577,645


// 自己的分析思路和大家分享下，希望能抛砖引玉。

// 分析：
// 一，当数组长度小于3时，最多需要调整一次就能满足条件
// 二，当数组长度大于等于3时，出现前一个元素y大于后一个元素z时，
// 如果y的前元素x不存在，让y=z即可；若x存在，会有以下情况

// x    y   z
// 1    3   2
// 2    3   1
// 3    3   1
// 2    3   2
// 要满足条件，需要如下调整：
// 1，当x<z,让y=z
// 2，当x>z,让z=y
// 3, 当x=z,让y=z
// 综合以上可以得到：当x存在且x>z，就让z=y，否则让y=z
// 当变更超过2次就不再满足条件


class Solution {
    public boolean checkPossibility(int[] nums) {
        if(nums.length < 3){
            return true;
        }
        int count = 0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] > nums[i+1]){
                count++;
                if(count > 1){
                    break;
                }
                if(i-1 >=0&&nums[i-1] > nums[i+1]){
                    nums[i+1] = nums[i];
                }else{
                    nums[i] = nums[i+1];
                }
            }
        }
        return count <= 1;
    }
}

// 作者：but-2
// 链接：https://leetcode-cn.com/problems/non-decreasing-array/solution/javafei-di-jian-shu-lie-by-but-2/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。