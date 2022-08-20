class Solution {
    public int minRefuelStops(int t, int f, int[][] st) {
//         Arrays.sort(st,(a,b)->{
//            if(a[0] == b[0])
//            {
//                return Integer.compare(b[1],a[1]);
//            }
//             return Integer.compare(a[0],b[0]);
//         });
        
        
        int n = st.length;
        long [] dp = new long[n+1];
        dp[0] = f;
       
        for(int i = 0; i<n; i++)
        {
            for(int j = i; j>=0; j--)
            {
                if(dp[j] >= st[i][0])
                {
                    dp[j+1] = Math.max(dp[j+1],dp[j]+(long)(st[i][1]));
                }
            }
            
        }
        
        for(int i = 0; i<=n; ++i)
        {
            if(dp[i] >=t)
                return i;
        }
        return -1;
        
    }
}