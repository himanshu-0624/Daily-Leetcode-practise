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
    public ListNode rotateRight(ListNode head, int k) {
         int n = 0;
        ListNode p = head;
        
        while(p != null)
        {
            p = p.next;
            n++;
        }
        
        if(k == 0 || n <= 1)
        {
            return head;
        }
        
        k = k%n;
        for(int i = 0; i<k; i++)
        {
            ListNode tem = head;
            while(tem.next.next!= null)
            {
                tem = tem.next;
            }
            tem.next.next = head;
            head = tem.next ;
            tem.next = null;
            
        }
        
        return head;
    }
}