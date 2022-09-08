class Solution 
{
    long [][] ans;
    long mod = 1_000_000_007;
    public int countPaths(int[][] g)
    {
        int n = g.length;
        int m = g[0].length;
        ans = new long[n][m];
        for(int i = 0; i<n; i++)
        {
            for(int j = 0; j<m; j++)
                ans[i][j] = -1;
        }
         for(int i = 0; i<n; i++)
        {
            for(int j = 0; j<m; j++)
            {  
                ans[i][j] = call(g,-1,i,j,n,m);
            }
        }
        long p = 0;
         for(int i = 0; i<n; i++)
        {
            for(int j = 0; j<m; j++)
            {
                p=(p+ans[i][j])%mod; 
            }
        }
        
        return (int)p;
    }
    
    long call(int [][] g, int val, int i, int j, int n, int m)
    {
        if(i<0 || j<0 || i>=n || j>=m)
            return 0l;
        if(g[i][j] <= val )
        {
            return 0l;
        }
        if(ans[i][j] != -1)
            return ans[i][j];
        
        long p = 1;
        p+=(call(g,g[i][j],i+1,j,n,m));
        p%=mod;
        p+=(call(g,g[i][j],i,j+1,n,m));
        p%=mod;
        p+=(call(g,g[i][j],i-1,j,n,m));
        p%=mod;
        p+=(call(g,g[i][j],i,j-1,n,m));
        p%=mod;
        return ans[i][j] = p;
    }
}