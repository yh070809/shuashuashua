14. Longest Common Prefix
Easy

3358

2040

Add to List

Share
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

0 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lower-case English letters.

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length ==0){
            return "";
        }
        //找到最短的那个字符串，因为common prefix 的最大长度不可能超过最短字符串
        int minLength = Integer.MAX_VALUE;
        for(String str : strs){
            minLength = Math.min(minLength,str.length());
        }
        //找到最短字符串的中间值
        int low = 0 , high = minLength;
        while(low < high){
            int mid = (high -low +1)/2 +low;
            if(isCommonPrefix(strs,mid)){
                low = mid;
            }else{
                high = mid -1;
            }
        }
        return strs[0].substring(0,low);
    }
    
    public boolean isCommonPrefix(String[] strs, int length){
        String str0 = strs[0].substring(0,length);
        int count = strs.length;
        for(int i = 1 ; i < count ; i++){
            String str = strs[i];
            for(int j = 0; j < length ; j++){
                if(str0.charAt(j) != str.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }
}


复杂度分析

时间复杂度：O(mn \log m)O(mnlogm)，其中 mm 是字符串数组中的字符串的最小长度，nn 是字符串的数量。二分查找的迭代执行次数是 O(\log m)O(logm)，每次迭代最多需要比较 mnmn 个字符，因此总时间复杂度是 O(mn \log m)O(mnlogm)。

空间复杂度：O(1)O(1)。使用的额外空间复杂度为常数。

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/longest-common-prefix/solution/zui-chang-gong-gong-qian-zhui-by-leetcode-solution/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。