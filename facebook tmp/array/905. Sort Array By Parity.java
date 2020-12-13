05. Sort Array By Parity
Easy

1418

80

Add to List

Share
Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

You may return any answer array that satisfies this condition.

 

Example 1:

Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 

Note:

1 <= A.length <= 5000
0 <= A[i] <= 5000
Accepted
277,022
Submissions
369,901


// 方法 3：原地算法
// 想法

// 如果希望原地排序，可以使用快排，一个经典的算法。

// 算法

// 维护两个指针 i 和 j，循环保证每刻小于 i 的变量都是偶数（也就是 A[k] % 2 == 0 当 k < i），所有大于 j 的都是奇数。

// 所以， 4 种情况针对 (A[i] % 2, A[j] % 2)：

// 如果是 (0, 1)，那么万事大吉 i++ 并且 j--。
// 如果是 (1, 0)，那么交换两个元素，然后继续。
// 如果是 (0, 0)，那么说明 i 位置是正确的，只能 i++。
// 如果是 (1, 1)，那么说明 j 位置是正确的，只能 j--。
// 通过这 4 种情况，循环不变量得以维护，并且 j-i 不断变小。最终就可以得到奇偶有序的数组

// 作者：LeetCode
// 链接：https://leetcode-cn.com/problems/sort-array-by-parity/solution/an-qi-ou-pai-xu-shu-zu-by-leetcode/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
class Solution {
    public int[] sortArrayByParity(int[] A) {
        int i = 0, j = A.length - 1;
        while (i < j) {
            if (A[i] % 2 > A[j] % 2) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }

            if (A[i] % 2 == 0) i++;
            if (A[j] % 2 == 1) j--;
        }

        return A;
    }
}

