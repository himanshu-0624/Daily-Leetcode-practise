class Solution {
    public String reverseStr(String s, int k) {
        char [] x = s.toCharArray();
        for(int i = 0; i<x.length; i+=(2*k))
        {
            int a = i;
            int b = i+k-1;
            while(a<b)
            {
                if(b >= x.length)
                    b--;
                else
                {
                    char c = x[a];
                    x[a] = x[b];
                    x[b] = c;
                    a++;
                    b--;
                }
            }
            
            
        }
        
        return new String(x);
    }
}