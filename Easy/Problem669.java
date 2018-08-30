// 2018.8.11
/*
https://leetcode.com/problems/trim-a-binary-search-tree/description/
*/
class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root.left != null) {
            root.left = trimBST(root.left, L, R);
        }
        if (root.right != null) {
            root.right = trimBST(root.right, L, R);
        }
        if (root.val < L || root.val > R) {
           if (root.left != null) {
               return root.left;
           } else if(root.right != null) {
               return root.right;
           } else {
               return null;
           }
        }
        return root;
    }
}
