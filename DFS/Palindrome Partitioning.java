Palindrome Partitioning 

Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example
Given s = "aab", return:

[
  ["aa","b"],
  ["a","a","b"]
]

思路
如果给出一个字符串abced。
我们可以试着切一刀看看切出来的两个是不是palindrome。我们也可以试着切两刀，看看切出来的三个是不是palindrome。我们可以一直切到。。。s.length() - 1刀。
这不就是罗列出所有切法的subsets么？

public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
    
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        
        ArrayList<String> list = new ArrayList<>();
        helper(s, res, list, 0);
        return res;
        
    }
    
    public void helper(String s, List<List<String>> res, ArrayList<String> list, int startIndex) {
        
        if (startIndex == s.length()) {
            res.add(new ArrayList<String>(list));
            return;
        }
        
        for (int i = startIndex; i < s.length(); i++) {
            String substring = s.substring(startIndex, i + 1);
            if (!isPalindrome(substring)) {
                continue;
            }
            list.add(substring);
            helper(s, res, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
    
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}