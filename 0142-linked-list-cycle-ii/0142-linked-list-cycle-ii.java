public class Solution {
    public ListNode detectCycle(ListNode head) {
          if(head == null || head.next ==null)return null;
        ListNode slow = head;
        ListNode fast = head;
        boolean u = false;
        while(fast!= null && slow != null)
        {
              slow = slow.next;
            if(fast.next == null)return null;
             fast = fast.next.next;
            if(slow == fast)
            {
                u = true;
                break;
            }
               
          
           
        }
        
        if( !u)return null;
        
        slow = head;
        while(slow!=fast)
        {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
        
    }
}