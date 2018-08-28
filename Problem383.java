// 2018.8.27
/*
https://leetcode.com/problems/ransom-note/description/
*/
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] letterArray = new int[26];
        for (char ch : magazine.toCharArray()) {
            ++letterArray[ch-'a'];
        }
        int index = 0;
        for(char ch : ransomNote.toCharArray()) {
            index = ch-'a';
            if (letterArray[index] == 0) {
                return false;
            }
            --letterArray[index];
        }
        return true;
    }
}
