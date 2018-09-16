// 2018.9.14
/*
https://leetcode.com/problems/keys-and-rooms/description/
*/

class Solution {
    
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        //紀錄還未去過的房間數量
        int result = rooms.size() - 1;
        
        //紀錄去過房間
        int[] record = new int[rooms.size()];
        ++record[0]; 
        
        //紀錄等等要訪問的房間
        Queue<Integer> queue = new LinkedList<>(rooms.get(0));
        
        while (!queue.isEmpty()) {
            int key = queue.remove();
            System.out.println(key);
            if (record[key] == 0) {
                ++record[key];
                --result;
                queue.addAll(rooms.get(key));
            }
            if (result == 0) {
                return true;
            }
        }
        return result == 0;
    }
    
}