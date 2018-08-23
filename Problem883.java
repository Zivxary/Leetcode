// 2018/8/5
/*
https://leetcode.com/problems/projection-area-of-3d-shapes/description/
*/
class Solution {
    public int projectionArea(int[][] grid) {
        
        int x = 0;
        int y = 0;
        int z = 0;
        
        int len = grid.length;
        int[] xTmp = new int[len];
        
        for(int i = 0; i < len; i++) {
            int yTmp = 0;
            for(int j = 0; j < len; j++) {
                if(grid[i][j] > xTmp[j]) {
                    xTmp[j] = grid[i][j];
                }
                if( i==len-1) {
                    x += xTmp[j];
                }
                if(grid[i][j] > yTmp) {
                    yTmp = grid[i][j];
                }
                if(grid[i][j] > 0) {
                    z++;
                }
            }
            y += yTmp;
        }
        
        return x+y+z;
    }
    
}