28. Implement strStr()
Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

 

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Example 3:

Input: haystack = "", needle = ""
Output: 0
 

Constraints:

0 <= haystack.length, needle.length <= 5 * 104
haystack and needle consist of only lower-case English characters.


// 子串逐一比较的解法最简单，将长度为 L 的滑动窗口沿着 haystack 字符串逐步移动，并将窗口内的子串与 needle 字符串相比较，时间复杂度为 O((N - L)L)O((N−L)L)

// 显示上面这个方法是可以优化的。双指针方法虽然也是线性时间复杂度，不过它可以避免比较所有的子串，因此最优情况下的时间复杂度为 O(N)O(N)，但最坏情况下的时间复杂度依然为 O((N - L)L)O((N−L)L)。



// class Solution {
//     public int strStr(String haystack, String needle) {
//         int L= needle.length(), n=haystack.length();
//         for(int start = 0 ; start < n -L +1 ; ++ start){
//             if(haystack.substring(start,start + L).equals(needle)){
//                 return start;
//             }
//         }
//         return -1;
//     }
// }


// 上一个方法的缺陷是会将 haystack 所有长度为 L 的子串都与 needle 字符串比较，实际上是不需要这么做的。

// 首先，只有子串的第一个字符跟 needle 字符串第一个字符相同的时候才需要比较。

//其次，可以一个字符一个字符比较，一旦不匹配了就立刻终止。
class Solution {
    public int strStr(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();
        if (L == 0) return 0;
        
        int pn = 0;
        while(pn < n - L + 1){
         // find the position of the first needle character
         // in the haystack string
         while(pn < n -L +1 && haystack.charAt(pn) != needle.charAt(0)) ++pn;
         
        //cpmpute the max match string 
        int currLen = 0 , pL =0; 
        while(pL < L && pn < n && haystack.charAt(pn) == needle.charAt(pL)){
            ++pn;
            ++pL;
            ++currLen;
        }    
        
       // if the whole needle string is found,
       // return its start position 
            if(currLen ==L) return pn -L;
        //otherwise, backtrack
            pn = pn -currLen +1;
        }
        return -1;

    }
}


// 复杂度分析

// 时间复杂度：最坏时间复杂度为 O((N - L)L)O((N−L)L)，最优时间复杂度为 O(N)O(N)。

// 空间复杂度：O(1)O(1)。