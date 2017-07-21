
Sort Colors 


Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent,
with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Example
Given [1, 0, 1, 2], sort it in-place to [0, 1, 1, 2].


可以设置左右指针left，right分别代表left左边的都是0，right右边的都是2。left初始化在位置0，right初始化在位置len-1

然后每次扫描会有三种情况。

1. 如果是2则让当前的值和right位置值交换，并让right左移一位。但是我们现在还不能扫描下一位，因为当前位置的值现在是交换过来的，我们并不知道他的值，因此不能执行i++。

2. 如果是0则让当前的值和left指针指向的值交换，然后left右移一位，然后可以扫描下一个位置，因为我们知道如果当前位置大于left位置，那么left位置值必然是1.

3. 如果是1则扫描下一个位置。

*******要注意的一点是循环终止条件 i <= right，因为right右边的我们已经知道是2了，所以没有必要再扫描了。

class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        //出口 handle corner case 
        
        if (nums ==null || nums.length <= 1 ){
            return;
        }
        
        int left =0;
        int right  = nums.length -1;
        int i = 0;
        
        while ( i <= right){
            if (nums[i] == 0){
                swap(nums,left,i);
                left ++;
                i++;
            }else if (nums[i] ==2){
                swap(nums,i,right);
                right --;
  
            }else {
                i++;
            }
        }
    }
      private void swap (int[] a,int i,int j){
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
}