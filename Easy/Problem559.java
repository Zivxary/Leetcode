// 2018.8.12
/*
https://leetcode.com/problems/maximum-depth-of-n-ary-tree/description/
*/
class Solution {
    public int maxDepth(Node root) {
        return Depth(root, 0);
    }
    
    private int Depth(Node root, int depth) {
        if (root == null) {
            return depth;
        }
        depth++;
        int maxDepth = depth;
        for (Node node: root.children) {
            maxDepth = Math.max(Depth(node, depth), maxDepth);
        }
        return maxDepth;
    }
}
