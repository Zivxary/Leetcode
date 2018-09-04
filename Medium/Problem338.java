// 2018.9.3
/*
https://leetcode.com/problems/counting-bits/description/
*/

class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        int n = 1;
        for (int i = 1; i <= num; ++i) {
            if (i >= (n << 1)) {
                n <<= 1;
            }
            result[i] = result[i - n] + 1;
        }
        return result;
    }
}