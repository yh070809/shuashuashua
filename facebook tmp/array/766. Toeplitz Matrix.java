766. Toeplitz Matrix
Easy

1217

84

Add to List

Share
Given an m x n matrix, return true if the matrix is Toeplitz. Otherwise, return false.

A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same elements.

 

Example 1:


Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
Output: true
Explanation:
In the above grid, the diagonals are:
"[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
In each diagonal all elements are the same, so the answer is True.
Example 2:


Input: matrix = [[1,2],[2,2]]
Output: false
Explanation:
The diagonal "[1, 2]" has different elements.
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 20
0 <= matrix[i][j] <= 99
 

Follow up:

What if the matrix is stored on disk, and the memory is limited such that you can only load at most one row of the matrix into the memory at once?
What if the matrix is so large that you can only load up a partial row into the memory at once?
Accepted
113,062
Submissions
172,156


// 方法一： 对角线法 【通过】
// 思路和算法

// 首先要想明白的是怎么判断 (r1, c1 和 (r2, c2) 这两个点属于一条对角线。通过观察可以发现，在满足 r1 - c1 == r2 - c2 的情况下，这两个点属于同一条对角线。

// 在上面的问题搞清楚的情况下，很容易就可以想到：让 groups[r-c] 存储每条对角线上遇到的第一个元素的值，如果之后遇到的任何一个值不等于之前存储的值，那么这个矩阵就不是托普利茨矩阵，否则就是。

//https://leetcode-cn.com/problems/toeplitz-matrix/solution/tuo-pu-li-ci-ju-zhen-by-leetcode/

// class Solution {
//     public boolean isToeplitzMatrix(int[][] matrix) {
//         Map<Integer, Integer> groups = new HashMap();
//         for (int r = 0; r < matrix.length; ++r) {
//             for (int c = 0; c < matrix[0].length; ++c) {
//                 if (!groups.containsKey(r-c))
//                     groups.put(r-c, matrix[r][c]);
//                 else if (groups.get(r-c) != matrix[r][c])
//                     return false;
//             }
//         }
//         return true;
//     }
// }



// 方法二： 检查左上邻居 【通过】
// 思路与算法

// 对于对角线上的元素来说，如果当前元素不是第一个出现的元素，那么它前面的元素一定在当前元素的左上角。可以推出，对于位于坐标 (r, c) 上的元素，只需要检查 r == 0 OR c == 0 OR matrix[r-1][c-1] == matrix[r][c] 就可以了

//链接：https://leetcode-cn.com/problems/toeplitz-matrix/solution/tuo-pu-li-ci-ju-zhen-by-leetcode/

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int r = 0; r < matrix.length; ++r)
            for (int c = 0; c < matrix[0].length; ++c)
                if (r > 0 && c > 0 && matrix[r-1][c-1] != matrix[r][c])
                    return false;
        return true;
    }
}
