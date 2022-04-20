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
         ListNode d = new ListNode(0);
        ListNode cur = d;
        int u = 0;
        while(l1 != null || l2 != null)
        {
            int x = (l1!=null) ? l1.val : 0;
             int y = (l2!=null) ? l2.val : 0;
            int sum = x+y+u;
            u = sum/10;
            cur.next = new ListNode(sum%10);
            cur = cur.next;
            if(l1!= null)l1 = l1.next;
             if(l2!= null)l2 = l2.next;
        }
       if(u>0)
       {
           cur.next = new ListNode(u);
       }
        
        
        return d.next; 
    }
    
    
  }