// 2018.8.11
/*
https://leetcode.com/problems/toeplitz-matrix/description/
*/
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int xlen = matrix.length;
        int ylen = matrix[0].length;
        int check ;
        for (int i = -xlen + 2 ; i < ylen - 1 ; i++) {
            int x = i < 0 ? -i : 0;
            int y = i > 0 ? i : 0;
            check = matrix[x][y];
            for (int j = 1; j < xlen ; j++) {
                x++;
                y++;
                if (x >= xlen || y >= ylen) {
                    break;
                }
                if (check != matrix[x][y]) {
                    return false;
                }
            }
        }
        return true;
    }
}
