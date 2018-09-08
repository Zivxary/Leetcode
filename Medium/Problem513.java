// 2018.9.5
/*
https://leetcode.com/problems/find-bottom-left-tree-value/description/
*/

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int result = root.val;
        while (queue.size() > 0) {
            TreeNode node = queue.remove();
            if (node.right != null) {
                queue.add(node.right);
                result = node.right.val;
            }
            if (node.left != null) {
                queue.add(node.left);
                result = node.left.val;
            }
        }
        return result;
    }
}