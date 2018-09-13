// 2018.9.13
/*
https://leetcode.com/problems/excel-sheet-column-number/description/
*/

class Solution {
    public int titleToNumber(String s) {
        int num = 0;
        for (char ch : s.toCharArray()) {
            num = num * 26 + ch - 'A' + 1;
        }
        return num;
    }
}

//練習JAVA 8 stream

class Solution {
    public int titleToNumber(String s) {
        return s.chars().reduce(0, (n, ch) -> n * 26 + ch - 'A' + 1);
    }
}