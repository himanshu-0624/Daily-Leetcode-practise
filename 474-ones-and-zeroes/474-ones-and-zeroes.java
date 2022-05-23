class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int [][] dp = new int[n+1][m+1];
        // m == 0
        // n == 1
        
        for(String s : strs)
        {
            int one = 0;
            int zero = 0;
            for(char c : s.toCharArray())
            {
                if(c == '1')
                    one++;
                else
                    zero++;
            }
            
            for(int i = n; i>=one; i--)
            {
                for(int j = m; j>=zero; j--)
                {
                    dp[i][j] = Math.max(dp[i][j],dp[i-one][j-zero]+1);
                }
            }
            
        }
        
        return dp[n][m];
    }
}