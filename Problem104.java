// 2018.8.18
/*
https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
*/
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.right),maxDepth(root.left)) + 1;
    }
}
