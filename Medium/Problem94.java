// 2018.9.15
/*
https://leetcode.com/problems/binary-tree-inorder-traversal/description/
*/

//先用遞歸寫一次，題目要求用迭代
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        inorder(root, list);
        return list;
    }
    
    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}

//用Stack
class Solution {
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) {
               continue; 
            }
            if (node.left == null && node.right == null) {
                result.add(node.val);
                continue;
            }
            //用Stack，所以順序跟遞歸的要反過來
            stack.add(node.right);
            stack.add(new TreeNode(node.val));
            stack.add(node.left);
        }
        return result;
    }
}