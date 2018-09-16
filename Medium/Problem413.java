// 2018.9.15
/*
https://leetcode.com/problems/arithmetic-slices/description/
*/

class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        
        int result = 0;
        
        for(int i = 0; i < A.length - 2; ++i) {
            int count = 0;
            int diff = A[i + 1] - A[i];
            for(; i < A.length - 2 && A[i + 2] - A[i + 1] == diff; ++i) {
                ++count;
            }
            result += (1 + count) * count / 2;
        }
        
        return result;
    }
}