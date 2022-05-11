class Solution {
    int [][] dp;
    public int countVowelStrings(int n) {
         dp = new int[n+1][5];
        for(int i = 0; i<=n; i++)
        {
            for(int j = 0; j<=4; j++)
            {
                dp[i][j] = -1;
            }
        }
        return call(n,0);
    }
    
    int call(int l, int i)
    {
        if(l == 0)
            return 1;
        
        if(dp[l][i] != -1)
            return dp[l][i];
        int ans = call(l-1,i);
        if(i<4)
        ans+=call(l,i+1);
        return dp[l][i] = ans;
    }
}