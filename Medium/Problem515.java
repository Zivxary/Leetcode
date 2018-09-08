// 2018.9.7
/*
https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
*/

//DFS解
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        //需要經常使用set方法，所以使用ArrayList
        //除非樹幾乎沒有分支，LinkedList才有點機會贏ArrayList，通常不可能
        List<Integer> result = new ArrayList<>();
        DFS(root, 0, result);
        return result;
    }
    
    private void DFS(TreeNode root, int depth, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (result.size() > depth) {
            result.set(depth, Math.max(root.val, result.get(depth)));
        } else {
            result.add(root.val);
        }
        DFS(root.left, depth + 1, result);
        DFS(root.right, depth + 1, result);
    }
}

//BFS解
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        
        //只有要在尾部增加資料，所以用LinkedList
        //用ArrayList，可能會遇到需要擴容，浪費點時間
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //用來記錄該層剩餘的節點數
        int remain = 1;
        //該層最大值
        int max = Integer.MIN_VALUE;
        
        //用 remain 紀錄可知道何時會到下一層
        //並把該層最大值，加入結果
        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();
            max = Math.max(max, node.val);
            if (node.left != null) {
               queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            if(--remain == 0) {
                remain = queue.size();
                result.add(max);
                max = Integer.MIN_VALUE;
            }
        }
        return result;
    }
}