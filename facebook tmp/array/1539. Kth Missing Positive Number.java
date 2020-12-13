1539. Kth Missing Positive Number
Easy

403

13

Add to List

Share
Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.

Find the kth positive integer that is missing from this array.

 

Example 1:

Input: arr = [2,3,4,7,11], k = 5
Output: 9
Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
Example 2:

Input: arr = [1,2,3,4], k = 2
Output: 6
Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
 

Constraints:

1 <= arr.length <= 1000
1 <= arr[i] <= 1000
1 <= k <= 1000
arr[i] < arr[j] for 1 <= i < j <= arr.length
Accepted
25,971
Submissions
48,691

//枚举
// class Solution {
//     public int findKthPositive(int[] arr, int k) {
//         int missCount = 0, lastMiss = -1, current = 1, ptr = 0; 
//         for (missCount = 0; missCount < k; ++current) {
//             if (current == arr[ptr]) {
//                 ptr = (ptr + 1 < arr.length) ? ptr + 1 : ptr;
//             } else {
//                 ++missCount;
//                 lastMiss = current;
//             }
//         }
//         return lastMiss;
//     }
// }

// 作者：LeetCode-Solution
// 链接：https://leetcode-cn.com/problems/kth-missing-positive-number/solution/di-k-ge-que-shi-de-zheng-zheng-shu-by-leetcode-sol/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。




class Solution {
    public int findKthPositive(int[] arr, int k) {
        if (arr[0] > k) {
            return k;
        }

        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            int x = mid < arr.length ? arr[mid] : Integer.MAX_VALUE;
            if (x - mid - 1 >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return k - (arr[l - 1] - (l - 1) - 1) + arr[l - 1];
    }
}

// 作者：LeetCode-Solution
// 链接：https://leetcode-cn.com/problems/kth-missing-positive-number/solution/di-k-ge-que-shi-de-zheng-zheng-shu-by-leetcode-sol/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。