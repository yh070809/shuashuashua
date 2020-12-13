1304. Find N Unique Integers Sum up to Zero
Easy

426

255

Add to List

Share
Given an integer n, return any array containing n unique integers such that they add up to 0.

 

Example 1:

Input: n = 5
Output: [-7,-1,1,3,4]
Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
Example 2:

Input: n = 3
Output: [-1,0,1]
Example 3:

Input: n = 1
Output: [0]
 

Constraints:

1 <= n <= 1000
Accepted
66,045
Submissions
86,371


// 方法一：构造
// 我们首先将最小的 n - 1 个自然数 0, 1, 2, ..., n - 2 放入数组中，它们的和为 sum。对于剩下的 1 个数，我们可以令其为 -sum，此时这 n 个数的和为 0，并且：

// 当 n = 1 时，我们构造的答案中只有唯一的 1 个数 0；

// 当 n > 1 时，我们构造的答案中包含 n - 1 个互不相同的自然数和 1 个负数；

// 因此这 n 个数互不相同，即我们得到了一个满足要求的数组。

// C++Python3


// 作者：LeetCode-Solution
// 链接：https://leetcode-cn.com/problems/find-n-unique-integers-sum-up-to-zero/solution/he-wei-ling-de-nge-wei-yi-zheng-shu-by-leetcode-so/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。  
class Solution {
public int[] sumZero(int n) {
        int[] ans = new int[n];
        int index = 0;
        for (int i = 1; i <= n / 2; i++) {
            ans[index++] = -i;
            ans[index++] = i;
        }
        return ans;
    }
}
// 作者：yuruiyin
// 链接：https://leetcode-cn.com/problems/find-n-unique-integers-sum-up-to-zero/solution/java-zheng-fu-shu-yi-0wei-zhong-xin-dui-cheng-by-n/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。