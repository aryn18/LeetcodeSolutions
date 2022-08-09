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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode current = head;
        int carry = 0;
        while(l1 !=null || l2 != null || carry > 0)
        {
            current.next = new ListNode();
            int node1 = 0;
            int node2 = 0;
            if(l1 != null){node1 = l1.val;}
            if(l2 != null){node2 = l2.val;}
            current = current.next;
            current.val = (node1+node2+carry)%10;
            carry = (node1+node2+carry)/10;
            if(l1 != null){l1 = l1.next;}
            if(l2 != null){l2 = l2.next;}
        }
        return head.next;
    }
}