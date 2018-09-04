// 2018.9.4
/*
https://leetcode.com/problems/custom-sort-string/description/
*/

class Solution {
    public String customSortString(String S, String T) {
        
        //紀錄 T 中出現的每個字母及數量
        Map<Character, Integer> map = new HashMap<>();
        
        //將 T 寫入 map 中
        for (int i = 0; i < T.length(); ++i) {
            char ch = T.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        //要回傳的字串
        StringBuilder result = new StringBuilder();
        
        //依 S 出現的字母 ，從 map 取數量，加到 result 
        for (int i = 0; i < S.length(); ++i) {
            char ch = S.charAt(i);
            int count = map.getOrDefault(ch, 0);
            for (int j = 0; j < count; j++) {
                result.append(ch);
            }
            map.remove(ch);
        }
        
        //沒在 S 出現過的字母，在 result 最後面補上
        for (Character ch : map.keySet()) {
            int count = map.get(ch);
            for (int j = 0; j < count; ++j) {
                result.append(ch);
            }
        }
        
        return sb.toString();
    }
}