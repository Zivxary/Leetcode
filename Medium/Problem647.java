// 2018.9.14
/*
https://leetcode.com/problems/palindromic-substrings/hints/
*/

class Solution {
    
    public int countSubstrings(String s) {
        int sum = 0;
        for(int i = 0; i < s.length(); ++i) {
            //處理"aba"之類的
            sum += Palindromic(s, i, i);
            //處理"abba"之類的
            sum += Palindromic(s, i, i + 1);
        }
        return sum;
    }
    
    private int Palindromic(String s, int start, int end) {
        //超出範圍
        if (start < 0 || end >= s.length()) {
            return 0;
        }
        //改正
        if (s.charAt(start) != s.charAt(end)) {
            return 0;
        }
        /* 看了解題思路，發現已比較過的就不用比了，所以改成上面的
        for (int i = 0; i < (end - start + 1) / 2; ++i) {
            if (s.charAt(i + start) != s.charAt(end - i)) {
                return 0;
            }
        }
        */
        return Palindromic(s, start - 1, end + 1) + 1;
    }
}