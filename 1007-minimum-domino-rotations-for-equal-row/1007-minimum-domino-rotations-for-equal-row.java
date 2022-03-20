class Solution {
    public int minDominoRotations(int[] t, int[] b) {
        int n = t.length;
        if(n == 1)
            return 0;
        
        int min = Integer.MAX_VALUE;
        
        for(int i= 1; i<=6; i++)
        {
            int cnt = 0;
           int cnt2 = 0;
            for(int j = 0; j<n; j++)
            {
                 if(t[j] != i && b[j] != i)
                {
                     cnt = Integer.MAX_VALUE;
                       cnt2 = Integer.MAX_VALUE;
                    break;
                }
                if(t[j] != i && b[j] == i )
                {
                    cnt++;
                }
                
                 if(b[j] != i && t[j] == i )
                {
                    cnt2++;
                }
               
            }
            
            min = Math.min(min,cnt);
            if(cnt!=Integer.MAX_VALUE)
            min = Math.min(cnt2,min);
        }
        
        
        if(min == Integer.MAX_VALUE)
            return -1;
        
        return min;
        
    }
}