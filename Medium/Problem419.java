// 2018.9.4
/*
https://leetcode.com/problems/battleships-in-a-board/description/
*/

class Solution {
    
    public int countBattleships(char[][] board) {
        int result = 0;
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (check(board, i, j)) {
                    ++result;
                    //System.out.println(i+", "+j);
                }
            }
        }
        return result;
    }
    
    
    private boolean check(char[][] board, int x, int y) {
        if (board[x][y] != 'X') {
            return false;
        }
        if ( x > 0 && board[x - 1][y] == 'X') {
            return false;
        }
        if ( y > 0 && board[x][y - 1] == 'X') {
            return false;
        }
        return true;
    }
}