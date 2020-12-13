1287. Element Appearing More Than 25% In Sorted Array
Easy

346

27

Add to List

Share
Given an integer array sorted in non-decreasing order, there is exactly one integer in the array that occurs more than 25% of the time.

Return that integer.

 

Example 1:

Input: arr = [1,2,2,6,6,6,6,7,10]
Output: 6
 

Constraints:

1 <= arr.length <= 10^4
0 <= arr[i] <= 10^5
Accepted
33,362
Submissions
55,475


// 方法一：遍历
// 由于数组 arr 已经有序，那么相同的数在 arr 中出现的位置也是连续的。因此我们可以对数组进行一次遍历，并统计每个数出现的次数。只要发现某个数出现的次数超过数组 arr 长度的 25%，那么这个数即为答案。

// 在计算数组 arr 长度的 25% 时，会涉及到浮点数。我们可以用整数运算 count * 4 > arr.length 代替浮点数运算 count > arr.length * 25%，减少精度误差。



// 方法二：二分查找
// 根据题目要求，满足条件的整数 x 至少在数组 arr 中出现了 span = arr.length / 4 + 1 次，那么我们可以断定：数组 arr 中的元素 arr[0], arr[span], arr[span * 2], ... 一定包含 x。

// 我们可以使用反证法证明上述的结论。假设 arr[0], arr[span], arr[span * 2], ... 均不为 x，由于数组 arr 已经有序，那么 x 只会连续地出现在 arr[0], arr[span], arr[span * 2], ... 中某两个相邻元素的间隔中，因此其出现的次数最多为 span - 1 次，这与它至少出现 span 次相矛盾。

// 有了上述的结论，我们就可以依次枚举 arr[0], arr[span], arr[span * 2], ... 中的元素，并将每个元素在数组 arr 上进行二分查找，得到其在 arr 中出现的位置区间。如果该区间的长度至少为 span，那么我们就得到了答案。


// 思路：
// - 根据arr.length找到超过25%处的下标
// - 保持固定距离（25%个数）
// - 如若两个指针所指的数相等及为所求
class Solution {
public int findSpecialInteger(int[] arr) {
        int before = arr.length / 4;
        for(int i = 0; before < arr.length; i++, before++){
            if(arr[i] == arr[before]) return arr[i];
        }
        return arr[arr.length-1];
    }
}
// 作者：RabbitZhao
// 链接：https://leetcode-cn.com/problems/element-appearing-more-than-25-in-sorted-array/solution/0ms-100-java-shuang-zhi-zhen-jian-ji-4xing-by-rabb/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。