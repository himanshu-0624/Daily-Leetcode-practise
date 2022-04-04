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
    public ListNode swapNodes(ListNode head, int k) {
         ListNode x = head;
        ListNode y = head;
        ListNode o = head;
        int n = k;
        k--;
       
        while(k>0){
            x = x.next;
            k--;
        }
        int p = 0;
        while(o.next!=null){
            o = o.next;
            p++;
        }
         int d = p-(n-1); 
        while(d>0){
            y = y.next;
            d--;
        }
        
        int g = x.val;
        x.val = y.val;
        y.val = g;
        
        return head;
    }
}