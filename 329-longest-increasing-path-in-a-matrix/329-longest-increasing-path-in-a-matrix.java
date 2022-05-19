class Solution {
    int n;
    int m;
    int [][] mat;
    
    public int longestIncreasingPath(int[][] ma) {
        n = ma.length;
        m = ma[0].length;
        mat = new int[n][m];
        for(int i = 0; i<n; i++)
        {
            for(int j = 0; j<m; j++)
            {
                mat[i][j] = -1;
            }
        }
       
        int ans = 1;
        for(int i = 0; i<n; i++)
        {
            for(int j = 0; j<m; j++)
            {
                ans = Math.max(ans,call(i,j,ma,Integer.MIN_VALUE));
            }
        }
        
        return ans;
    }
    
    int call(int i, int j, int [][] ma, int pval)
    {
        if(i<0 || j<0 || i>=n || j>=m)
            return 0;
         
          if(ma[i][j] <= pval)
              return 0;
        
        if(mat[i][j] != -1)
            return mat[i][j];
        
          int p = 0;
         
          p = Math.max(p,call(i+1,j,ma,ma[i][j]));                  
          p = Math.max(p,call(i-1,j,ma,ma[i][j]));
          p = Math.max(p,call(i,j+1,ma,ma[i][j]));
          p = Math.max(p,call(i,j-1,ma,ma[i][j]));
        
        return mat[i][j] = 1+ p;
    }
}