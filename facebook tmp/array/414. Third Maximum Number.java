414. Third Maximum Number
Easy

819

1478

Add to List

Share
Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

Example 1:
Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.
Example 2:
Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
Example 3:
Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.
Accepted
186,899
Submissions
611,653


class Solution {
    public int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) throw new RuntimeException("error");

        TreeSet<Integer> set = new TreeSet<>();
        for (Integer elem : nums) {
            set.add(elem);
            if (set.size() > 3) set.remove(set.first());
        }
        
        return set.size() < 3 ? set.last() : set.first();   // set.last() 里面最大的元素
    }
}
