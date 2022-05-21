class Solution {
    public int coinChange(int[] c, int am) {
        int n = c.length;
        int [][] dp = new int[am+1][n+1];
        for(int i = 1; i<=am; i++)
        {
            dp[i][0] = -1;
        }
        
        for(int i = 0; i<=n; i++)
        {
            dp[0][i] = 0;
        }
        
        for(int i = 1; i<=am; i++)
        {
            for(int j = 1; j<=n; j++)
            {
                int val = c[j-1];
                dp[i][j] = -1;
                if(i-val >=0 && dp[i-val][j] != -1)
                {
                    dp[i][j] = 1 + dp[i-val][j];
                    
                }
                
                if(dp[i][j-1] != -1)
                {
                    if(dp[i][j] != -1)
                    {
                        dp[i][j] = Math.min(dp[i][j],dp[i][j-1]);
                    }
                    else
                    {
                        dp[i][j] = dp[i][j-1];
                    }
                    
                }
                
            }
        }
        
        return dp[am][n];
    }
}