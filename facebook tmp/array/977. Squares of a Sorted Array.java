977. Squares of a Sorted Array
Easy

1683

102

Add to List

Share
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

 

Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.
Accepted
350,798
Submissions
486,766

// 方法一没有利用「数组 AA 已经按照升序排序」这个条件。显然，如果数组 AA 中的所有数都是非负数，那么将每个数平方后，数组仍然保持升序；如果数组 AA 中的所有数都是负数，那么将每个数平方后，数组会保持降序。

// 这样一来，如果我们能够找到数组 AA 中负数与非负数的分界线，那么就可以用类似「归并排序」的方法了。具体地，我们设 \textit{neg}neg 为数组 AA 中负数与非负数的分界线，也就是说，A[0]A[0] 到 A[\textit{neg}]A[neg] 均为负数，而 A[\textit{neg}+1]A[neg+1] 到 A[n-1]A[n−1] 均为非负数。当我们将数组 AA 中的数平方后，那么 A[0]A[0] 到 A[\textit{neg}]A[neg] 单调递减，A[\textit{neg}+1]A[neg+1] 到 A[n-1]A[n−1] 单调递增。

// 由于我们得到了两个已经有序的子数组，因此就可以使用归并的方法进行排序了。具体地，使用两个指针分别指向位置 \textit{neg}neg 和 \textit{neg}+1neg+1，每次比较两个指针对应的数，选择较小的那个放入答案并移动指针。当某一指针移至边界时，将另一指针还未遍历到的数依次放入答案。

// // 

// class Solution {
//     public int[] sortedSquares(int[] A) {
//         int n = A.length;
//         int negative = -1;
//         for (int i = 0; i < n; ++i) {
//             if (A[i] < 0) {
//                 negative = i;
//             } else {
//                 break;
//             }
//         }

//         int[] ans = new int[n];
//         int index = 0, i = negative, j = negative + 1;
//         while (i >= 0 || j < n) {
//             if (i < 0) {
//                 ans[index] = A[j] * A[j];
//                 ++j;
//             } else if (j == n) {
//                 ans[index] = A[i] * A[i];
//                 --i;
//             } else if (A[i] * A[i] < A[j] * A[j]) {
//                 ans[index] = A[i] * A[i];
//                 --i;
//             } else {
//                 ans[index] = A[j] * A[j];
//                 ++j;
//             }
//             ++index;
//         }

//         return ans;
//     }
// }

// 同样地，我们可以使用两个指针分别指向位置 00 和 n-1n−1，每次比较两个指针对应的数，选择较大的那个逆序放入答案并移动指针。这种方法无需处理某一指针移动至边界的情况，读者可以仔细思考其精髓所在。

class Solution {
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        for (int i = 0, j = n - 1, pos = n - 1; i <= j;) {
            if (A[i] * A[i] > A[j] * A[j]) {
                ans[pos] = A[i] * A[i];
                ++i;
            } else {
                ans[pos] = A[j] * A[j];
                --j;
            }
            --pos;
        }
        return ans;
    }
}



// 作者：LeetCode-Solution
// 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array/solution/you-xu-shu-zu-de-ping-fang-by-leetcode-solution/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。