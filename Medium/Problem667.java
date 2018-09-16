// 2018.9.16
/*
https://leetcode.com/problems/beautiful-arrangement-ii/description/
*/

class Solution {
    public int[] constructArray(int n, int k) {
        int[] result = new int[n];
        
        int min = 1;
        int max = n;
        
        int i = 0;
        for (; i < n; i++) {
            if (k <= 0) {
                break;
            }
            if ((i & 1) == 0) {
                result[i] = min++;
            } else {
                result[i] = max--;
            }
            --k;
        }
        
        boolean flag = (i & 1) == 0;
        int num = flag ? max : min;
        for (; i < n; ++i) {
            result[i] =  flag ? num-- : num++ ;
        }
        
        return result;
    }
}