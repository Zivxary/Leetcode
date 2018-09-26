// 2018.9.18
/*
https://leetcode.com/problems/invert-binary-tree/description/
*/

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmpNode = root.left;
        root.left = root.right;
        root.right = tmpNode;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}