// 2018.8.8
/*
https://leetcode.com/problems/binary-gap/description/
*/
class Solution {
    public int binaryGap(int N) {
        int n = N;
        while ((n & 1) == 0) {
            n = n>>1;
        }
        if (n==1)
            return 0;
        
        int ans = 0;
        int tmp = 0;
        while (n > 0) {
            if ((n & 1) == 0) {
                tmp++;
            } else {
                tmp = 0;
            }
            if(ans < tmp) {
                ans = tmp;
            }
            n = n>>1;
        }
        return ans+1;
    }
}