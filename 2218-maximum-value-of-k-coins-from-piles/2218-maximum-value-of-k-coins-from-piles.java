class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        int m = piles.get(0).size();
        for(List<Integer> gg : piles)
        {
            m = Math.max(gg.size(),m);
        }
        int [][] x = new int[n][m+1];
        for(int i = 0; i<n; i++)
        {
            for(int j= 1; j<=m; j++)
            {
                if(piles.get(i).size() >=j)
                {int val = piles.get(i).get(j-1);
                x[i][j] = val+x[i][j-1];}
                else
                    x[i][j] = x[i][j-1];
            }
        }
        
        int [][] dp = new int[n+1][k+1];
        
        for(int i = 1; i<=n; i++)
        {
            for(int j = 0; j<=k; j++)
            {
                
                  dp[i][j] = dp[i-1][j];
             for(int l = 0; l<=j; l++)
             {
                 int v = 0;
                if(l<m)
                v = x[i-1][l];
                else
                {
                    v = x[i-1][m];
                }
                 int cnt  = j-l;
                 dp[i][j] = Math.max(dp[i][j],v+dp[i-1][cnt]);
                 
             }
                
              
                

                
            }
        }
        
        int max = 0;
        for(int i = 0; i<=k; i++)
        {
            max = Math.max(dp[n][i],max);
        }
        
        return max;
    }
}