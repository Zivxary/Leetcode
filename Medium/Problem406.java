// 2018.9.7
/*
https://leetcode.com/problems/queue-reconstruction-by-height/description/
*/

class Solution {
    
    public int[][] reconstructQueue(int[][] people) {
        
        //int[][] 轉 List<int[]>
        //需要插入，所以使用LinkedList
        List<int[]> list = new LinkedList<>();
        for (int[] pair : people) {
            list.add(pair);
        }
        if(list.isEmpty()) {
            return people;
        }
        
        //先以 H 由大到小排
        //若相等，再以 K 由小到大排
        //即 (H大, K小), (H大, K大), (H小, K小), (H小, K大) 
        list.sort (new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return b[0] - a[0];
                } 
                return a[1] - b[1];
            }
        });
        
        //從 H 第二大開始排
        //直接取出，並以 K 當指標插入
        //原理：H 大的，不會被 H 小插入中間而影響到
        //所以先排 H 大的，再排次大的...
        int nowH = list.get(0)[0];
        for(int i = 0; i < people.length; ++i) {
            if(nowH != list.get(i)[0]) {
                int[] tmp = list.remove(i);
                list.add(tmp[1], tmp);
            }
        }
        
        //List<int[]> 轉 int[][]
        int[][] result = new int[people.length][2];
        list.toArray(result);
        
        return result;
    }
}
