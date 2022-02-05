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
    public ListNode mergeKLists(ListNode[] l) {
        if(l.length == 0)return null;
        PriorityQueue<ListNode> x = new PriorityQueue<>((a,b)->{
            return a.val - b.val;
        });
        ListNode h = new ListNode(0);
        ListNode p = h;
         for(ListNode f : l)
         {
             if(f!= null)
             x.add(f);
         }
        
        while(!x.isEmpty())
        {
            p.next = x.poll();
            p = p.next;
            ListNode k = p.next;
            if(k != null)
            {
                x.add(k);
            }
        }
        
        
        p.next = null;
        return h.next;
    }
}