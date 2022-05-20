class Solution {
    int dp[][];
    public int uniquePathsWithObstacles(int[][] obs) {
        dp = new int[obs.length][obs[0].length];
        for(int i = 0;i<obs.length; i++)
                         {
                             for(int j = 0; j<obs[0].length; j++)
                             {
                                 dp[i][j] = -1;
                             }
                         }
        return dfs(obs,0,0);
    }
    
    int dfs(int [][] g, int i, int j)
    {
    
        if(i<0 || j<0 || i>=g.length || j >= g[0].length || g[i][j] == 1)return 0;
        if(dp[i][j] !=-1)return dp[i][j];
         if(i+1 == g.length && j+1 == g[0].length)return 1;
        g[i][j] =1;
         int ans = dfs(g,i+1,j) + dfs(g,i,j+1);
        dp[i][j] = ans;
        g[i][j] = 0;
        return ans;
        
    }
}