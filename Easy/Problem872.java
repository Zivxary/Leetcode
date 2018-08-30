// 2018/8/8
/*
https://leetcode.com/problems/leaf-similar-trees/description/
*/

class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list = new LinkedList<>();
        leafValueSequence(root1,list);
        return checkLeafSimilar(true,root2,list);
        
    }
    
    private void leafValueSequence(TreeNode root,List<Integer> list) {
        if(root.left == null && root.right == null) {
            list.add(root.val);
        }
        if(root.left != null) {
            leafValueSequence(root.left,list);
        }
        if(root.right != null) {
            leafValueSequence(root.right,list);
        }
    }
    
    private boolean checkLeafSimilar(boolean check,TreeNode root,List<Integer> list) {
        if(!check)
            return check;
            
        if(root.left == null && root.right == null) {
            check = root.val == list.remove(0);
        }
        if(root.left != null) {
            check = checkLeafSimilar(check,root.left,list);
        }
        if(root.right != null) {
            check = checkLeafSimilar(check,root.right,list);
        }
        return check;
    }
}