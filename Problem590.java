// 2018.8.15
/*
https://leetcode.com/problems/n-ary-tree-postorder-traversal/description/
*/
class Solution {
    
    private List<Integer> list = new LinkedList<>();
    
    public List<Integer> postorder(Node root) {
        myPostorder(root);
        return list;
    }
    
    private void myPostorder(Node root) {
        if (root == null) {
            return;
        }
        for (Node node : root.children) {
            myPostorder(node);
        } 
        list.add(root.val);
    }
    
}
