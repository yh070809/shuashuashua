163. Missing Ranges
Easy

447

2022

Add to List

Share
You are given an inclusive range [lower, upper] and a sorted unique integer array nums, where all elements are in the inclusive range.

A number x is considered missing if x is in the range [lower, upper] and x is not in nums.

Return the smallest sorted list of ranges that cover every missing number exactly. That is, no element of nums is in any of the ranges, and each missing number is in one of the ranges.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b

class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int n = nums.length;

        if (n == 0) {
            return Collections.singletonList(formatRange(lower, upper));
        }

        List<String> missingRanges = new ArrayList<>();

        // Edge case 1) Missing ranges at the beginning
        if (nums[0] > lower) {
            missingRanges.add(formatRange(lower, nums[0] - 1));
        }

        // Missing ranges between array elements
        for (int i = 1; i < n; ++i) {
            if (nums[i] - nums[i - 1] > 1) {
                missingRanges.add(formatRange(nums[i - 1] + 1, nums[i] - 1));
            }
        }
        
        // Edge case 2) Missing ranges at the end
        if (nums[n - 1] < upper) {
            missingRanges.add(formatRange(nums[n - 1] + 1, upper));
        }

        return missingRanges;
    }

    // formats range in the requested format
    String formatRange(int lower, int upper) {
        if (lower == upper) {
            return String.valueOf(lower);
        } else {
            return lower + "->" + upper;
        }
    }
}