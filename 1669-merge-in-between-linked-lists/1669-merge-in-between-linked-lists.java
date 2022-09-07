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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode a1 = list1;
        ListNode a2 = list1;
         while(a-1>0)
         {
             a1 = a1.next;
             a--;
         }
        while(b>=0)
        {
            a2 =a2.next;
            b--;
        }
        ListNode last = list2;
        while(last.next!= null)
            last = last.next;
        a1.next = list2;
        last.next = a2;
        return list1;
    }
}