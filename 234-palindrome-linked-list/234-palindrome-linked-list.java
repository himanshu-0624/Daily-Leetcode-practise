class Solution {
    public boolean isPalindrome(ListNode head) {
        StringBuffer z = new StringBuffer();
        while(head!= null)
        {
            z.append(head.val);
            head = head.next;
        }
        char [] x = z.toString().toCharArray();
    int i = 0;
        int j = x.length-1;
        while(i<j)
        {
            if(x[i]!=x[j])return false;
            i++;
            j--;
        }
        return true;
    }
}