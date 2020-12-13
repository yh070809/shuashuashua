31. Next Permutation
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

The replacement must be in place and use only constant extra memory.

 

Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]
Example 4:

Input: nums = [1]
Output: [1]

class Solution {
    public void nextPermutation(int[] nums) {
        //从后往前，找到递增后突然下降的那一个点，一直递增则说明已经是最大了，
        //突然下降的那个数字说明递增区间有可以往前移的数字，才有可能找到全排列的下一个最大
        // e.g. 1,2,4,7,3 
        // [7,3](从后往前看)是递增的， 4 突然下降， 说明[7,3]里有可以和4交换的
        int i = nums.length -2;
        while(i >=0 && nums[i+1] <= nums[i]){
            i--;
        }
        
        // 从最后一位开始， 找到比要交换的数字大一个的数，进行两两交换
        // [7,3]里 7 > 4 说明 7是需要和4交换的那一点
        // 交换后 1,2,7,4,3 
        if( i>=0){
            int j = nums.length -1;
            while(j >= 0 && nums[j] <= nums[i]){
                j--;
            }
            swap(nums,i,j);
        }
        // reverse 交换后的整个区间，采用两两交换，以交换值为中心点 因为左边一定比交换的值大，右边一定比交换的值小
        //将交换后的区间[4,3]进行排列， 小的放在前面
        //最后的结果1,2,7,3,4
        reverse(nums,i+1);
    }
    
    private void reverse(int[] nums, int start){
     int i = start, j= nums.length -1;
         while( i < j){
            swap(nums,i,j);
             i++;
             j--;
         }   
    }
        
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}