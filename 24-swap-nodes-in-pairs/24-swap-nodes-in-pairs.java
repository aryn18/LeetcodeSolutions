/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p = dummy;
        ListNode c = head;
        while(c!=null && c.next!=null)
        {
            p.next = c.next;
            c.next = c.next.next;
            p.next.next = c;
            c = c.next;
            p = p.next.next;
        }
        return dummy.next;
    }
}