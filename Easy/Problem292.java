// 2018.8.23
/*
https://leetcode.com/problems/nim-game/description/
*/
class Solution {
    public boolean canWinNim(int n) {
        return n != n >> 2 << 2;
    }
}
