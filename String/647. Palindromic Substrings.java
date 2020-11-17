647. Palindromic Substrings

Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:

Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
 

Example 2:

Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += extractPalindrome(s, i, i);
            count += extractPalindrome(s, i, i + 1);
        }
        return count;
        
    }
    
    public int extractPalindrome(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}

// class Solution {
// public int countSubstrings(string s) {
//         int dp[s.length()][s.length()];
//         int res = 0;
//         for (int i = s.length() - 1; i >= 0; i--) {
//         for (int j = i; j < s.length(); j++) {
//             dp[i][j] = s[i] == s[j] && (j - i < 3 || dp[i + 1][j - 1]);
//             if(dp[i][j]) ++res;
//         }
//     }
//     return res;
//     }
// }