class Solution {
    public int maxDistToClosest(int[] s) {
        int max  = 1;
        int i = 0;
        int n = s.length-1;
        int c = 0;
        while(s[i]==0)
        {
            c++;
            i++;
        }
        max = Math.max(max,c);
        c = 0;
        while(s[n] == 0)
        {
            n--;
            c++;
        }
         max = Math.max(max,c);   
        
        while(i<n)
        {
             c = 1;
            i++;
           while(i<n && s[i] == 0)
            {
                i++;
                c++;
            }
            
           
            
            max = Math.max(c/2,max);
        }
        return max;
    }
}