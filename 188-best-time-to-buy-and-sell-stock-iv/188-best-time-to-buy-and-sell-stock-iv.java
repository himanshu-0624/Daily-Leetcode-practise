class Solution {
    public int maxProfit(int k, int[] p)
    {
        int n = p.length;
        if(k >= n/2)
        {
            return call(p);
        }
        int [][] dp = new int[k+1][n];
        for(int i = 1; i<=k; i++)
        {
            int mx = -p[0];
            for(int j = 1; j<n; j++)
            {
                dp[i][j] = Math.max(dp[i][j-1],mx+p[j]);
                mx = Math.max(mx,dp[i-1][j-1] - p[j]);
            }
        }
        return dp[k][n-1];
    }
    
    int call(int [] p)
    {
        int g = 0;
        for(int i  =1; i<p.length; i++)
        {
            if(p[i]-p[i-1] > 0)
            g+=(p[i]-p[i-1]);
        }
        return g;
    }
}