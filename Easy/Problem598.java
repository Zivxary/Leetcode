// 2018.8.30
/*
https://leetcode.com/problems/range-addition-ii/description/
*/

class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int row = m;
        int col = n;
        for (int[] op : ops) {
            row = Math.min(row, op[0]);
            col = Math.min(col, op[1]);
        }
        return row * col;
    }
}