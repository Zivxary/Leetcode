// 2018.8.22
/*
https://leetcode.com/problems/search-in-a-binary-search-tree/description/
*/
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) {
                return root;
            }
            root = root.val < val ? root.right : root.left;
        }
        return null;
    }
}
