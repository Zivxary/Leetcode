// 2018.8.26
/*
https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/
*/

class Solution {
    
    int tmp = -1;
    int ans = Integer.MAX_VALUE;
    
    public int minDiffInBST(TreeNode root) {
        findMinDiff(root);
        return ans;
    }
    
    private void findMinDiff(TreeNode node) {
        if( ans == 1 )
            return;
        if (node.left != null) {
            findMinDiff(node.left);
        }
        if(tmp != -1) {
            ans = Math.min(ans, node.val - tmp);
        }
        tmp = node.val;
        if (node.right != null) {
            findMinDiff(node.right);
        }
    }
}