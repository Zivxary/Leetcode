/*
https://leetcode.com/problems/projection-area-of-3d-shapes/description/
*/
class Solution {
    public int projectionArea(int[][] grid) {
        
        int x = 0;
        int y = 0;
        int z = 0;
        
        int len = grid.length;
        int[] xtmp = new int[len];
        
        for(int i = 0; i < len; i++) {
            int yTmp = 0;
            for(int j = 0; j < len; j++) {
                if(grid[i][j] > xtmp[j]) {
                    xtmp[j] = grid[i][j];
                }
                if( i==len-1) {
                    x += xtmp[j];
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