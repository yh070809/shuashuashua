859. Buddy Strings
Easy

815

560

Add to List

Share
Given two strings A and B of lowercase letters, return true if you can swap two letters in A so the result is equal to B, otherwise, return false.

Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at A[i] and A[j]. For example, swapping at indices 0 and 2 in "abcd" results in "cbad".

 

Example 1:

Input: A = "ab", B = "ba"
Output: true
Explanation: You can swap A[0] = 'a' and A[1] = 'b' to get "ba", which is equal to B.
Example 2:

Input: A = "ab", B = "ab"
Output: false
Explanation: The only letters you can swap are A[0] = 'a' and A[1] = 'b', which results in "ba" != B.
Example 3:

Input: A = "aa", B = "aa"
Output: true
Explanation: You can swap A[0] = 'a' and A[1] = 'a' to get "aa", which is equal to B.
Example 4:

Input: A = "aaaaaaabc", B = "aaaaaaacb"
Output: true
Example 5:

Input: A = "", B = "aa"
Output: false
 

Constraints:

0 <= A.length <= 20000
0 <= B.length <= 20000
A and B consist of lowercase letters.


// 这个问题看似简单，实则要注意的坑很多。这也证明了提交通过率极低的现象。
// 首先可以根据A、B是否一样长，排除极端情况。很明显，如果A.length != B.length，返回false。
// 在A、B一样长的前提下，可分为2种情况：

// A == B 这样情况下，如果A(或B，相等了，无所谓)中有重复的字符，就能满足题目的对调条件。
// A != B 这种情况下，可以遍历一次，找出A、B不相等元素的下标，分别记为index1，index2。最后交换A中的index1，index2处的2个元素，然后和B比较即可。这里需要注意如果A、B不相等的元素个数如果不为2，即为false



class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length())
            return false; //如果A、B长度都不等，返回false
        if (A.equals(B)) {
            for (int i = 0; i < A.length() - 1; i++) {
                if (A.indexOf(A.charAt(i), i + 1) != -1) { //如果A == B，则检查A/B中有无重复字符，如果有，重复字符对调一下就可以，满足条件。
                    return true;
                }
            }
            return false;
        }
        int index1 = -1, index2 = -1, count = 0;
        for (int i = 0; i < A.length(); i++) { //一次遍历找出2个不同元素的下标
            if (A.charAt(i) != B.charAt(i)) {
                count++;
                if (count == 1)
                    index1 = i;
                else if (count == 2)
                    index2 = i;
                else
                    return false;
            }
        }
        return count == 2 && A.charAt(index1) == B.charAt(index2) && A.charAt(index2) == B.charAt(index1);
    }
}


//链接：https://leetcode-cn.com/problems/buddy-strings/solution/zhao-chu-bu-deng-yuan-su-xia-biao-dui-diao-hou-bi-/
