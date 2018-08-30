// 2018/8/6
/*
https://leetcode.com/problems/middle-of-the-linked-list/description/
*/

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode ans = head;
        ListNode index = head;
        int recond = 0;
        while (index != null) {
            recond++;
            index = index.next;
            if (recond > 1) {
                recond = 0;
                ans = ans.next;
            }
        }
        
        return ans;
    }
}