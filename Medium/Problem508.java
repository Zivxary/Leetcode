// 2018.9.16
/*
https://leetcode.com/problems/most-frequent-subtree-sum/description/
*/

class Solution {
    
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null) {
            return new int[0];
        }
        
        //紀錄 subtree 的總和 對應 出現次數;
        Map<Integer, Integer> map = new HashMap<>();
        
        recordSubtree(root, map);
        
        return getResult1(map);
    }
    
    private int recordSubtree(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        sum += recordSubtree(root.left, map);
        sum += recordSubtree(root.right, map);
        sum += root.val;
        
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }
    
    //用for迴圈取結果，效率較好，可讀性較差
    private int[] getResult1(Map<Integer, Integer> map) {
        
        int max = 0;
        List<Integer> list = new LinkedList<>();
        //取得結果，並存入list
        for(Integer key : map.keySet()) {
            int tmp = map.get(key);
            if (max < tmp) {
                max = tmp;
                list.clear();
                list.add(key);
                continue;
            }
            if (max == tmp) {
                list.add(key);
            }
        }
        //將list寫入陣列
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            result[i] = list.get(i);
        }
        return result;
    }
    
    //用JAVA 8 stream，較慢但可讀性較好
    private int[] getResult2(Map<Integer, Integer> map) {
        int max = map.values()
                    .stream()
                    .max(Integer::compare)
                    .get();
        
        return map.keySet()
                .stream()
                .filter(k -> map.get(k) == max)
                .mapToInt(t -> t)
                .toArray();
    }
}