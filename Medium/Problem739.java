// 2018.9.10
/*
https://leetcode.com/problems/daily-temperatures/description/
*/

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        //要回傳的結果
        int[] result = new int[temperatures.length];
        
        //與當前指標的距離，溫度-30為Key
        //溫度範圍為30-100，所以取71
        int[] map = new int[71];
        
        //紀錄要用到的未來溫度
        Stack<Integer> recordStack = new Stack<>();
        for (int i = temperatures.length - 1; i >= 0; --i) {
            
            //指標往回一步，所有紀錄的距離都要加1
            for (Integer recordTemp : recordStack) {
                ++map[recordTemp - 30];
            }
            
            int nowTemp = temperatures[i];
            //從堆疊內，找出最近又大於現在溫度的值
            //並到map中取距離，記錄到結果中
            //而現在的值，存入堆疊內
            //如果不大於，則捨棄該值，並將對應map值歸0
            while (!recordStack.isEmpty()) {
                int recordTemp = recordStack.peek();
                if (nowTemp < recordTemp) {
                    result[i] = map[recordTemp - 30];
                    break;
                }
                map[recordStack.pop() - 30] = 0;
            }
            recordStack.push(nowTemp);
        }
        
        return result;
    }
}