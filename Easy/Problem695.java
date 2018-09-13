// 2018.9.12
/*
https://leetcode.com/problems/max-area-of-island/description/
*/

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == 1) {
                    result = Math.max(result,  countAreaByDFS(grid, i, j));
                }
            }
        }
        return result;
    }
    
    private int countAreaByBFS(int[][] grid, int x, int y) {
        int area = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        while (!queue.isEmpty()) {
            Point point = queue.remove();
            if (isIsland(grid, point)) {
                ++area;
                grid[point.x][point.y] = 0;
                queue.add(new Point(point.x + 1, point.y));
                queue.add(new Point(point.x - 1, point.y));
                queue.add(new Point(point.x, point.y + 1));
                queue.add(new Point(point.x, point.y - 1));
            }
        }
        return area;
    }
    
    private int countAreaByDFS(int[][] grid, int x, int y) {
        int area = 0;
        if (isIsland(grid, new Point(x, y))) {
            ++area;
            grid[x][y] = 0;
            area += countAreaByDFS(grid, x + 1, y)
                + countAreaByDFS(grid, x - 1, y)
                + countAreaByDFS(grid, x, y + 1)
                + countAreaByDFS(grid, x, y - 1);
        }
        return area;
    }
    
    private boolean isIsland(int[][] grid, Point point) {
        if (point.x < 0 
            || point.x >= grid.length
            || point.y < 0
            || point.y >= grid[0].length
           ) {
            return false;
        } else {
            return grid[point.x][point.y] > 0;
        }
    }
}