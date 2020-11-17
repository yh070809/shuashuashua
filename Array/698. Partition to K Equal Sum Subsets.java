698. Partition to K Equal Sum Subsets
Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.

 

Example 1:

Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
Output: True
Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.

// 1) 首先计算数组中所有元素和sum，如果sum不能被k整除，则结果为false，否则计算划分后每组的和 subSum = sum/k;

// 2) 对数组进行非降序排序，从后往前遍历，如果最大的元素比subSum大，说明存在元素没法划分，结果为false，否则将所有等于sunSum的元素挑出来单独为一组，分成i组，此时剩下j个元素;

// 3) 将剩下的j个元素(0,1,2..j-1)分成k-i组，可以使用回溯法不断的去尝试，对于元素j-1,如果可以放入第一组且剩下j-1个元素可以放入k-i组中，则存在这样的划分，否则，将元素j-1从第一组拿出来尝试放入第二组，知道所有的元素尝试完;

// 4) 如果元素尝试完都没有找到可能的划分，则不存在这样的划分.




class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = sum(nums);
        //如果不能整除 说明不能平均分成k份
        if(sum % k != 0){
            return false;
        }
        //每一份的值
        int subSum = sum / k ;
        Arrays.sort(nums);
        int beginIndex = nums.length -1;
        //如果最后一个比subsum大 表示无论如何都放不进去，直接return false
        if(nums[beginIndex] > subSum){
            return false;
        }
        
        while(beginIndex >= 0 && nums[beginIndex] == subSum){
            beginIndex --;
            //如果最后一个值和subsum值相等 桶的数量也减一
            k--;
        }
        return partition(new int[k], nums,beginIndex, subSum);
    }
    
    public boolean partition(int[] subsets, int[] nums, int index ,int target){
        if (index < 0){
            return true;
        }
        
        int selected = nums[index];
        for (int i = 0 ; i < subsets.length ; i++){
            if(subsets[i] + selected<= target){
                subsets[i] += selected;
                if(partition(subsets, nums,index -1, target)){
                    return true;
                }
                subsets[i] -= selected;
            }
        }
        return false;
        
    }
    
    
    public int sum(int[] nums){
        int res = 0 ;
        for(int n : nums){
            res += n;
        }
        return res;
    }
    
    
    
    
}