1283. Find the Smallest Divisor Given a Threshold
Given an array of integers nums and an integer threshold, we will choose a positive integer divisor and divide all the array by it and sum the result of the division. Find the smallest divisor such that the result mentioned above is less than or equal to threshold.

Each result of division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).

It is guaranteed that there will be an answer.

Example 1:

Input: nums = [1,2,5,9], threshold = 6
Output: 5
Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1. 
If the divisor is 4 we can get a sum to 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2). 
Example 2:

Input: nums = [2,3,5,7,11], threshold = 11
Output: 3
Example 3:

Input: nums = [19], threshold = 5
Output: 4

// 方法一： 二分查找
// 分析：
// 我们记函数cal(x)cal(x)为以xx作为除数，数组里每个数除以xx后的累加和
// 易知，cal(x)cal(x)是一个单调递减的函数
// 利用cal(x)cal(x)函数的单调性，我们可以利用二分查找的方法快速定位满足条件的最小除数
// 算法：
// 首先设计一个函数cal(x)cal(x)来计算以xx为除数时的累加和（注意向上取整）
// 定义上下边界lolo和hihi
// 每次取区间中点作为除数xx，对其应用函数cal()cal(),取得结果resres
// 当resres大于thresholdthreshold时，考虑到cal(x)cal(x)是个单调减函数，我们应当到右区间[mid+1, hi][mid+1,hi]继续搜素
// 反之，我们在左区间[lo, mid][lo,mid]继续搜索，注意mid可能是我们的所求值，不应当剔除




class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int lo = 1, hi = 1_000_000;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            // 计算以mid为除数的结果
            int res = cal(nums, mid); 
            // 1.如果这个结果数大于阀值， 说明除数mid取的太小了，我们在[mid+1, hi]中继续查找
            // 2.如果这个结果数小于等于阀值，说明除数mid取得太大，或者满足要求，我们在[lo,mid]中继续查找
            // 注意在2的情形下，mid可能是我们所要求的解，不应被剔除在搜索区间之外
            if (res > threshold) lo = mid+1;
            else                 hi = mid;

        }
        return lo;
    }
    private int cal(int[] nums, int div) {
        int sum = 0;
        for (int n : nums) {
            sum += n / div;
            // 向上取整
            if (n % div != 0) sum += 1; 
        }
        return sum;
    }
}

