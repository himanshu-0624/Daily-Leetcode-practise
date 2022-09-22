class Solution {
    public String reverseWords(String s) {
        String [] x = s.split(" ");
        StringBuffer ans = new StringBuffer();
        for(int i = 0;  i<x.length; i++)
        {
            StringBuffer p = new StringBuffer(x[i]);
            p.reverse();
            ans.append(p);
            if(i != x.length-1)
            {
                ans.append(" ");
            }
        }
        return ans.toString();
    }
}