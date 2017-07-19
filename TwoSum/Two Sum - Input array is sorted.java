Two Sum - Input array is sorted 

Given an array of integers that is already sorted in ascending order,
find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such 
that they add up to the target, where index1 must be less than index2. P
lease note that your returned answers (both index1 and index2) are not zero-based.


Example
Given nums = [2, 7, 11, 15], target = 9
return [1, 2]


public class Solution {
    /*
     * @param nums an array of Integer
     * @param target = nums[index1] + nums[index2]
     * @return [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
       int[] indexArray = new int[2];

        // handle corner cases
        if (numbers == null || numbers.length == 0) {
            return null;
        }

        // Value <-> index map
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            hashMap.put(numbers[i], i);
        }
        // At this point we get a hashmap like this:
        // 2, 0
        // 7, 1
        // 11, 2
        // 15, 3

        // For every element, check if (target-element) exists in array
        // If exists, we update indexArray and return
        // otherwise, go to the next loop and check the next element
        for (int i = 0; i < numbers.length; i++) {
            if (hashMap.containsKey(target - numbers[i])) {
                indexArray[0] = i;
                indexArray[1] = hashMap.get(target - numbers[i]);
                // Remember we can't use the same element twice!!
                if (indexArray[0] == indexArray[1])
                    continue;
                return indexArray;
            }
    }
}
}