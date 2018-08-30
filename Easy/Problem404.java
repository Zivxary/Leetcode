// 2018.8.29
/*
https://leetcode.com/problems/sum-of-left-leaves/description/
*/

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int sum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
           sum += root.left.val;
        } else if (root.left != null){
            sum += sumOfLeftLeaves(root.left);
        }
        if (root.right != null) {
            sum += sumOfLeftLeaves(root.right);
        }
        return sum;
    }
}