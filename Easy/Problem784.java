// 2018.9.11
/*
https://leetcode.com/problems/letter-case-permutation/description/
*/

class Solution {
    
    //大小寫轉換用
    private static final int reverseCase = 'z' - 'Z';
    //結果
    private List<String> result;
    
    public List<String> letterCasePermutation(String S) {
        result = new LinkedList<>();
        result.add("");
        for (char c : S.toCharArray()) {
            int size = result.size();
            
            //如果是數字就執行一次listAppend，然後下一輪
            //Character.isDigit(char a)
            if ('0' <= c && c <= '9') {
                listAppend(c, size);
                continue;
            }
            //先複製一遍並存入
            result.addAll(result);
            //先對原來的範圍逐個增加字元
            listAppend(c, size);
            //轉換大小寫
            c += (c > 'Z' ? -1 : 1) * reverseCase;
            //在對複製的範圍逐個增加轉換後的字元
            listAppend(c, size);
        }
        return result;
    }
    
    //對 result內 第0 ~ end-1個 分別加上字元(c)
    private void listAppend(char c, int end) {
        for(int i = 0; i < end; i++) {
            result.add(result.remove(0) + c);
        }
    } 
}

