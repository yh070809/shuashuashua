169. Majority Element
Easy

4110

238

Add to List

Share
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2




// 方法一：哈希表
// 思路

// 我们知道出现次数最多的元素大于 \lfloor \dfrac{n}{2} \rfloor⌊ 
// 2
// n
// ​	
//  ⌋ 次，所以可以用哈希表来快速统计每个元素出现的次数。

// 算法

// 我们使用哈希映射（HashMap）来存储每个元素以及出现的次数。对于哈希映射中的每个键值对，键表示一个元素，值表示该元素出现的次数。

// 我们用一个循环遍历数组 nums 并将数组中的每个元素加入哈希映射中。在这之后，我们遍历哈希映射中的所有键值对，返回值最大的键。我们同样也可以在遍历数组 nums 时候使用打擂台的方法，维护最大的值，这样省去了最后对哈希映射的遍历。


// class Solution {
//   private Map<Integer, Integer> countNums(int[] nums) {
//         Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
//         for (int num : nums) {
//             if (!counts.containsKey(num)) {
//                 counts.put(num, 1);
//             } else {
//                 counts.put(num, counts.get(num) + 1);
//             }
//         }
//         return counts;
//     }

//     public int majorityElement(int[] nums) {
//         Map<Integer, Integer> counts = countNums(nums);

//         Map.Entry<Integer, Integer> majorityEntry = null;
//         for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
//             if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
//                 majorityEntry = entry;
//             }
//         }

//         return majorityEntry.getKey();
//     }
// }


// 方法二：排序
// 思路

// 如果将数组 nums 中的所有元素按照单调递增或单调递减的顺序排序，那么下标为 \lfloor \dfrac{n}{2} \rfloor⌊ 
// 2
// n
// ​	
//  ⌋ 的元素（下标从 0 开始）一定是众数。

class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}

