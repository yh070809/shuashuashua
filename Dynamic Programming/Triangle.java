Triangle

Description
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.


Notice
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.


Example
Given the following triangle:

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).


思路
我们用f[i][j]表示在[i][j]这个坐标的最短路径的值。这个值其实是上一层的两个可以往下走到[i][j]的坐标的坐标[i - 1][j - 1]和坐标[i - 1][j]的最短路径的最小值。那么f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j])。
初始化，从顶上一直往左下或者右下只有一种走法。注意初始化开数组的时候是开一个m x m的数组。
最后从最后一行[i - 1]里找最小值就是从顶到底的最小路径。


Code
public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        if (triangle == null || triangle.length == 0 || triangle[0] == null || triangle[0].length == 0) {
            return 0;
        }
        int m = triangle.length;
        int[][] f = new int[m][m];
        
        f[0][0] = triangle[0][0];
        for (int i = 1; i < m; i++) {
            f[i][0] = f[i - 1][0] + triangle[i][0];
            f[i][i] = f[i - 1][i - 1] + triangle[i][i];
        }
        
        for (int i = 2; i < m; i++) {
            for (int j = 1; j < i; j++) {
                f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle[i][j];
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            if (min > f[m - 1][i]) {
                min = f[m - 1][i];
            }
        }
        
        return min;
    }
}