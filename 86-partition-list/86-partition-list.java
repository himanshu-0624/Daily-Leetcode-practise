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
    public ListNode partition(ListNode h, int x) {
        ListNode a1 = new ListNode(0);
        ListNode a2 = new ListNode(0);
        ListNode h1 = a1;
        ListNode h2 = a2;
        while(h!=null)
        {
            if(h.val < x)
            {
               a1.next = h;
               h = h.next;
               a1 = a1.next;
               a1.next = null;
            }
            else
            {
                a2.next = h;
               h = h.next;
               a2 = a2.next;
               a2.next = null;
            }
        }
        
        a1.next = h2.next;
        return h1.next;
        
    }
}