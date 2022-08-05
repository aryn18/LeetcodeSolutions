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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode a = dummy;
        ListNode b = dummy;
        
        for(int i = 1; i <= n+1; i++){
            b = b.next;
        }
        
        while(b != null){
            a = a.next;
            b = b.next;
        }
        
        a.next = a.next.next;
        return dummy.next;
    }
}