896. Monotonic Array
Easy

837

40

Add to List

Share
An array is monotonic if it is either monotone increasing or monotone decreasing.

An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].

Return true if and only if the given array A is monotonic.

 

Example 1:

Input: [1,2,2,3]
Output: true
Example 2:

Input: [6,5,4,4]
Output: true
Example 3:

Input: [1,3,2]
Output: false
Example 4:

Input: [1,2,4,5]
Output: true
Example 5:

Input: [1,1,1]
Output: true
 

Note:

1 <= A.length <= 50000
-100000 <= A[i] <= 100000
Accepted
131,522
Submissions
226,606

class Solution {
    public boolean isMonotonic(int[] A) {
        int store = 0;
        for (int i = 0; i < A.length - 1; ++i) {
            int c = Integer.compare(A[i], A[i+1]);
            if (c != 0) {
                if (c != store && store != 0)
                    return false;
                store = c;
            }
        }

        return true;
    }
}
// 方法二：一次遍历
// 思路

// 要在一次遍历中执行该检查，我们将会处理由 \{-1, 0, 1\}{−1,0,1} 组成的比较流，分别对应 <，==，或 >。例如，对于数组 [1, 2, 2, 3, 0]，我们将会看到数据流 (-1, 0, -1, 1)。

// 算法

// 跟踪 store，它的值等于所看到的第一个非零比较值（如果存在）。一旦我们看到与之相反的比较值，那么答案就变成了 False。

// 否则，每次比较值都必定在集合 \{-1, 0\}{−1,0} 中或是在 \{0, 1\}{0,1} 中，此时数组是单调的。

// 作者：LeetCode
// 链接：https://leetcode-cn.com/problems/monotonic-array/solution/dan-diao-shu-lie-by-leetcode/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。