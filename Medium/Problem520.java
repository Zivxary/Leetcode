// 2018.9.11
/*
https://leetcode.com/problems/detect-capital/description/
*/

import java.util.regex.Pattern;

class Solution {
    public boolean detectCapitalUse(String word) {
        return Pattern.matches("^[a-z]+$|^[A-Z][a-z]+$|^[A-Z]+$", word);
    }
}