class Solution {
    public int minDistance(String word1, String word2) {
        char [] x = word1.toCharArray();
        char [] y = word2.toCharArray();
        int n = x.length;
        int m = y.length;
        
        int [][] dp = new int[n+1][m+1];
        
        for(int i = 1; i<=n; i++)
        {
            for(int j = 1; j<=m; j++)
            {
                if(x[i-1] == y[j-1])
                {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else
                {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]); 
                }
            }
        }
        
        int max = dp[n][m];
        
        return x.length-max + y.length-max;
        
    }
}