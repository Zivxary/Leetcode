// 2018.8.18
/*
https://leetcode.com/problems/binary-number-with-alternating-bits/description/
*/
class Solution {
    public boolean hasAlternatingBits(int n) {
        int a = n ^ (n >> 1);
        while ((a & 1) == 1) {
            a >>= 1;
        }
        return a == 0;
    }
}
