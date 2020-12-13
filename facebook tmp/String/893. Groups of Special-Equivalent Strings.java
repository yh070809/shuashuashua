893. Groups of Special-Equivalent Strings
Easy

293

1180

Add to List

Share
You are given an array A of strings.

A move onto S consists of swapping any two even indexed characters of S, or any two odd indexed characters of S.

Two strings S and T are special-equivalent if after any number of moves onto S, S == T.

For example, S = "zzxy" and T = "xyzz" are special-equivalent because we may make the moves "zzxy" -> "xzzy" -> "xyzz" that swap S[0] and S[2], then S[1] and S[3].

Now, a group of special-equivalent strings from A is a non-empty subset of A such that:

Every pair of strings in the group are special equivalent, and;
The group is the largest size possible (ie., there isn't a string S not in the group such that S is special equivalent to every string in the group)
Return the number of groups of special-equivalent strings from A.

 
Example 1:

Input: ["abcd","cdab","cbad","xyzz","zzxy","zzyx"]
Output: 3
Explanation: 
One group is ["abcd", "cdab", "cbad"], since they are all pairwise special equivalent, and none of the other strings are all pairwise special equivalent to these.

The other two groups are ["xyzz", "zzxy"] and ["zzyx"].  Note that in particular, "zzxy" is not special equivalent to "zzyx".
Example 2:

Input: ["abc","acb","bac","bca","cab","cba"]
Output: 3
 

Note:

1 <= A.length <= 1000
1 <= A[i].length <= 20
All A[i] have the same length.
All A[i] consist of only lowercase letters.

// 因为所有 A[i] 都具有相同的长度，所以没有必要考虑长度问题了。

// 奇数位和偶数位上的所有字符分别一致，就是一组，如abcde、cdabe，两者奇数位上均是a/c/e，偶数位上都是b/d，最后都能通过有限次的交换得到对方

// 所以，搜集每个字符串中奇数位和偶数位的字符，按字典序排好序后使用Set来筛选，如abcde的奇数位为ace，偶数位为bd，拼接出来加入Set，即acebd；acbde的奇数位为abe，偶数位为cd，最后拼接为abecd，不为同一组

// 作者：mmmmmJCY
// 链接：https://leetcode-cn.com/problems/groups-of-special-equivalent-strings/solution/java-by-zxy0917-18/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
class Solution {
    public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<>();
        for (String str : A) {
            char[] chars = str.toCharArray();
            String odd = "", even = "";
            for (int i = 0; i < chars.length; i++) {
                //如果是奇数位
                if ((i & 1) == 1) {
                    odd += str.charAt(i);
                } else {
                    //如果为偶数位
                    even += str.charAt(i);
                }
            }
            //排序后拼接
            char[] oddArr = odd.toCharArray();
            Arrays.sort(oddArr);
            char[] evenArr = even.toCharArray();
            Arrays.sort(evenArr);
            set.add(new String(oddArr) + new String(evenArr));
        }

        return set.size();
    }
}

