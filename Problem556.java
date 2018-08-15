// 2018.8.15
/*
https://leetcode.com/problems/reshape-the-matrix/description/
*/
class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        int col = nums[0].length;
        if (row * col != r * c) {
            return nums;
        }
        int[][] result = new int[r][c];
        int nowRow = 0;
        int nowCol = 0; 
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = nums[nowRow][nowCol];
                nowCol++;
                if (nowCol >= col) {
                    nowCol = 0;
                    nowRow++;
                }
            }
        }
        return result;
    }
}
