// 2018.8.30
/*
https://leetcode.com/problems/maximum-binary-tree/description/
*/

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length == 0) {
            return null;
        }
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, index));
        root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, index + 1, nums.length));
        return root;
    }
}