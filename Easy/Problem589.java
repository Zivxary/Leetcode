// 2018.9.2
/*
https://leetcode.com/problems/n-ary-tree-preorder-traversal/description/
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new LinkedList<>();
        DFS(root, list);
        return list;
    }
    
    private void DFS(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        for (Node node : root.children) {
            DFS(node, list);
        }
    }
}