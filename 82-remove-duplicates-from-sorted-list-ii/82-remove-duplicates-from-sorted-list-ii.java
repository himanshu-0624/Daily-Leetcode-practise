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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = new ListNode(0);
        cur.next = head;
        ListNode ans = cur;
       
        while( cur.next!= null && cur.next.next!= null)
        {
            ListNode h = cur.next;
            ListNode ha = cur.next.next;
           
           
            if(ha.val == h.val)
            {    
                 while(h!= null && h.val == ha.val)
                {
                h = h.next;
               }
                cur.next = h;
            }
            else
            {
                cur = cur.next;
            }
           
           
        }
        
        return ans.next;
    }
}