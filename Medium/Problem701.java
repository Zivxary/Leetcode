// 2018.9.5
/*
https://leetcode.com/problems/insert-into-a-binary-search-tree/description/
*/

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val > val && root.left == null) {
            root.left = new TreeNode(val);
            return root;
        }
        if (root.val > val) {
            insertIntoBST(root.left, val);
            return root;
        }
        // root.val <= val
        if (root.right == null) {
            root.right = new TreeNode(val);
            return root;
        }
        insertIntoBST(root.right, val);
        return root;
    }
}