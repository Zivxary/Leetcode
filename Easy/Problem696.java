// 2018.9.15
/*
https://leetcode.com/problems/count-binary-substrings/description/
*/

//寫過迴文的題目，所以用類似的方法解
class Solution {
    public int countBinarySubstrings(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); ++i) {
            sum += count(s, i, i + 1, s.charAt(i) == '1');
        }
        return sum;
    }
    
    private int count(String s, int start, int end, boolean type) {
        if (start < 0 || end >= s.length()) {
            return 0;
        }
        if ((s.charAt(start) != s.charAt(end)) 
            && (s.charAt(start) == '1' ? type : !type) ) {
            return count(s, start - 1, end + 1, type) + 1;
        }
        return 0;
    }
}

//依解答的想法實現
class Solution {
    public int countBinarySubstrings(String s) {
        
        if(s.length() <= 1) {
            return 0;
        }
        //目前為 1 或 0
        char c = s.charAt(0);
        
        //紀錄 同數字的數量
        //例 11001 => [2,2,1]
        int[] group = new int[s.length()];
        ++group[0];
        
        //目前group的紀錄位置;
        int index = 0;
        
        for (int i = 1; i < s.length(); ++i) {
            if (c == s.charAt(i)) {
                ++group[index];
                continue;
            }
            //以下 c != s.charAt(i)
            c = s.charAt(i);
            group[++index] = 1;
        }
        
        //計算結果
        int result = 0;
        for (int i = 1; i < s.length() && group[i] > 0; ++i) {
            result += Math.min(group[i-1], group[i]);
        }
        
        return result;
    }
}