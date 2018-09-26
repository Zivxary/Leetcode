// 2018.9.17
/*
https://leetcode.com/problems/beautiful-arrangement/description/
*/

//解題方法
/*
從最大的開始找，因為任何數與1都能整除
所以遞歸，最底層的回傳，就是N == 1 時，且不用在意剩下啥數
找符合 題目要求的 array[i] % i == 0 或是 i % array[i] == 0
若是找到，就把刪除該值的陣列，與 i - 1，傳入自己
再繼續找下一個符合的
*/

//用LinkedList存取資料
class Solution {
    public int countArrangement(int N) {
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; ++i) {
            list.add(i);
        }
        return helper(N, list);
    }
    
    private int helper(int n, List<Integer> list) {
        if (n == 1) {
            return 1;
        }
        int sum = 0;
        for (int i = 0; i < list.size(); ++i) {
            int tmp = list.remove(0);
            if (tmp % n == 0 || n % tmp == 0) {
                sum += helper(n - 1, new LinkedList(list));
            }
            list.add(tmp);
        }
        return sum;
    }
}

//用陣列存取資料，效率較好
class Solution {
    public int countArrangement(int N) {
        int[] array = new int[N];
        for (int i = 0; i < N; ++i) {
            array[i] = i + 1;
        }
        return helper(N, array);
    }
    
    private int helper(int n, int[] array) {
        if (n == 1) {
            return 1;
        }
        int sum = 0;
        for (int i = 0; i < array.length; ++i) {
            //交換的用意在，如果符合條件
            //要刪除的數值就會被放在最後面
            //複製時，就只要複製array.length - 1 個即可
            //最後要交換回來，否則最後一個數不會循環到
            int tmp = swapLast(array, i);
            if (tmp % n == 0 || n % tmp == 0) {
                sum += helper(n - 1, Arrays.copyOf(array,array.length - 1));
            }
            swapLast(array, i);
        }
        return sum;
    }
    
    //第i個 與 最後一個交換數值
    private int swapLast(int[] array, int index) {
        int last = array.length - 1;
        int tmp = array[last];
        array[last] = array[index];
        array[index] = tmp;
        return array[last];
    }
}