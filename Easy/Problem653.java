// 2018.9.13
/*
https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
*/

class Solution { 
    
    
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        setPutAll(set, root);
        //再遍歷一遍，如果set內有diff
        //且diff與num不同，即return true
        for(Integer num : set) {
            int diff = k - num;
            if (set.contains(diff) && num != diff) {
                return true;
            }
        }
        return false;
    }
    
    //先把Tree所有節點存入Set
    //因為是Binary Search Tree，所以不會有重複的
    private void setPutAll(Set<Integer> set, TreeNode root) {
        if (root == null) {
            return;
        }
        set.add(root.val);
        setPutAll(set, root.left);
        setPutAll(set, root.right);
    }
}

//解答：邊set.add邊確認最好