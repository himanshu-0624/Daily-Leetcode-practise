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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)return head;
        
        return mergesort(head, null);
    }
    
  ListNode mergesort(ListNode start, ListNode end)
  {
      if(start == end)
          return start;
      
      ListNode fast = start;
      ListNode slow = start;
      while(fast!= end && fast.next!= end )
      {
             fast = fast.next.next;
             slow = slow.next;
      }
      
       ListNode p = slow.next;
       slow.next = null;
       start = mergesort(start,slow);       
       slow = mergesort(p,end);
       ListNode[] ans = merge(start,slow);
      return ans[0];
  }
    
   ListNode[] merge(ListNode a1, ListNode a2)
   {
       
       ListNode ans = new ListNode(0);
      ListNode l = ans;
       while(a1!= null && a2!=null)
       {
           if(a1.val > a2.val)
           {
               l.next  = a2;
               l = l.next;
               a2 = a2.next;
           }
           else
           {
                l.next  = a1;
               l = l.next;
               a1 = a1.next;
           }
       }
       
       while(a1!=null)
       {
              l.next  = a1;
               l = l.next;
               a1 = a1.next;
       }
       
       while(a2!=null)
       {
              l.next  = a2;
               l = l.next;
               a2 = a2.next;
       }
       
       l.next = null;
       return new ListNode[]{ans.next,l};
   }
    
}










