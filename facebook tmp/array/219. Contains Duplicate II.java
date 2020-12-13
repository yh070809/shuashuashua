219. Contains Duplicate II
Easy

1102

1233

Add to List

Share
Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false
Accepted
303,534
Submissions
791,524
Seen this question in a real interview before?


// 思路

// 用散列表来维护这个kk大小的滑动窗口。

// 算法

// 在之前的方法中，我们知道了对数时间复杂度的 搜索 操作是不够的。在这个方法里面，我们需要一个支持在常量时间内完成 搜索，删除，插入 操作的数据结构，那就是散列表。这个算法的实现跟方法二几乎是一样的。

// 遍历数组，对于每个元素做以下操作：
// 在散列表中搜索当前元素，如果找到了就返回 true。
// 在散列表中插入当前元素。
// 如果当前散列表的大小超过了 kk， 删除散列表中最旧的元素。
// 返回 false。

//https://leetcode-cn.com/problems/contains-duplicate-ii/solution/cun-zai-zhong-fu-yuan-su-ii-by-leetcode/
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; ++i) {
        if (set.contains(nums[i])) return true;
        set.add(nums[i]);
        if (set.size() > k) {
            set.remove(nums[i - k]);
        }
    }
    return false;
        
    }
}