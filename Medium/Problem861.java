// 2018.9.14
/*
https://leetcode.com/problems/score-after-flipping-matrix/description/
*/

class Solution {
    public int matrixScore(int[][] A) {
        
        int row = A.length;
        int col = A[0].length;
        
        //每個ROW的第一個值必定為1，這樣才能最大
        for (int i = 0; i < row; ++i) {
            if (A[i][0] == 0) {
                for (int j = 0; j < col; ++j) {
                    A[i][j] = 1 - A[i][j];
                }
            }
        }
        
        //每個COL要盡量越多1
        for (int i = 0; i < col; ++i) {
            int sum = 0;
            for (int j = 0; j < row; ++j) {
                sum += A[j][i];
            }
            if (sum * 2 < row ) {
                for (int j = 0; j < row; ++j) {
                    A[j][i] = 1 - A[j][i];
                }
            }
        }
        
        //計算和
        int result = 0;
        for (int i = 0; i < row; ++i) {
            int tmp = 0;
            //計算 1 ROW 的值
            for (int j = 0; j < col; ++j) {
                tmp = (tmp << 1) + A[i][j]; 
            }
            result += tmp;
        }
        return result;
    }
}

//討論區解答
class Solution {
    public int matrixScore(int[][] A) {
        int M = A.length;
        int N = A[0].length;
        //A[i][0] 必為一
        //(1 << (N - 1)) 計算最高位的值
        int res = (1 << (N - 1)) * M;
        
        //j = 0 不用計算，res已算過，且算法也不同
        for (int j = 1; j < N; j++) {
            int cur = 0;
            for (int i = 0; i < M; i++) {
                //計算每Column有幾個1
                //對於A[i][0] = 0 的結果要相反
                cur += A[i][j] == A[i][0] ? 1:0;
            }
            //Math.max(cur, M - cur) 求該列能弄出最多的1
            //(1 << (N - j - 1)) 該列對應的值
            res += Math.max(cur, M - cur) * (1 << (N - j - 1));
        }
        return res;
    }
}