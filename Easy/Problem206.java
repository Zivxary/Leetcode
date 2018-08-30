// 2018.8.20
/*
https://leetcode.com/problems/reverse-linked-list/description/
*/
class Solution {
    
    ListNode tmp = null;
    ListNode result = null;
    
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node = reverseList(head.next);
        if (node == null) {
            result = tmp = head;
        } else {
            tmp.next = head;
            tmp = tmp.next;
            tmp.next = null;
        }
        return result;
    }
}
