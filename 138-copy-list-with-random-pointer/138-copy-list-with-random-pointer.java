/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node t = head;
       
        while(t!= null)
        {
             Node p = new Node(t.val);
            p.next  = t.next;
            t.next = p;
            t = t.next.next;
        }
        t = head;
        while(t!= null)
        {
            Node c = t.random;
            if(c != null)
            t.next.random = c.next;
            t = t.next.next;
        }
        t = head;
        Node ans = new Node(0);
        Node add = ans;
        while(t!= null)
        {
            Node j = t.next;
            ans.next = j;
            ans = ans.next;
            t.next = t.next.next;
            t = t.next;
        }
        return add.next;
    }
}