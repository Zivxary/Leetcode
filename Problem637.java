// 2018.8.17
/*
https://leetcode.com/problems/average-of-levels-in-binary-tree/description/
*/
class Solution {
    
    List<Numbers> list = new ArrayList<>();
    
    public List<Double> averageOfLevels(TreeNode root) {
        putValue(root,0);
        return list.stream().map(Numbers::average).collect(Collectors.toList());//.filter(n -> n > 0)
    }
    
    private void putValue(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if(list.size() <= depth ){
            list.add(new Numbers());
        }
        putValue(root.right, depth + 1);
        putValue(root.left, depth + 1);
        list.get(depth).add(root.val);
    }
    
    class Numbers {
        double sum = 0;
        int count = 0;

        void add(int num) {
            sum += num;
            count++;
        }
        double average() {
            if(count <= 0)
                return 0;
            return sum / count;
        }
    }
}
