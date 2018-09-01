// 2018.9.1
/*
https://leetcode.com/problems/binary-tree-pruning/description/
*/

class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
           return null; 
        }
        TreeNode n1 = pruneTree(root.left);
        TreeNode n2 = pruneTree(root.right);
        if(root.val == 0 && n1 == null && n2 == null) {
            return null;
        }
        root.left = n1;
        root.right = n2;
        return root;
    }
}