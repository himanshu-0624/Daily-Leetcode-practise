class Solution {
    public int numberOfWeakCharacters(int[][] prop)
    {
        Arrays.sort(prop,(a,b) ->
                    {
                       if(a[0] == b[0])
                           return Integer.compare(b[1],a[1]);
                        return Integer.compare(b[0],a[0]);
                    });  
        
        // int i = 0;
        int mx = -1;
        int cnt =  0;
        int n = prop.length;
        for(int i = 0; i<n; )
        {
            int j = i;
            while(j<n && prop[i][0] == prop[j][0])
               j++;
            for(int k = i; k<j; k++)
            {
                if(prop[k][1] < mx)
                    cnt++;
            }
            
            for(int k = i; k<j; k++)
                mx  = Math.max(prop[k][1],mx);
            i = j;
        }
        return cnt;
    }
}