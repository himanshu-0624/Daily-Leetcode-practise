class Solution {
    public int getMaximumGold(int[][] grid) {
        int ans = 0;
        
        int n = grid.length;
        int m = grid[0].length;
        
        for(int i = 0 ; i<n; i++)
        {
            for(int j = 0; j<m; j++)
            {
                ans = Math.max(ans,call(grid,i,j,n,m));
            }
        }
        
        return ans;
    }
    
    int call(int [][] mat, int i, int j, int n, int m)
    {
        if(i<0 || i>=n || j<0 || j>=m)
            return 0;
        if(mat[i][j] == 0)
            return 0;
        int val = mat[i][j];
        mat[i][j] = 0;
        
        int val1 = call(mat,i+1,j,n,m);
        val1 = Math.max(call(mat,i-1,j,n,m),val1);
         val1 = Math.max(call(mat,i,j+1,n,m),val1);
         val1 = Math.max(call(mat,i,j-1,n,m),val1);
        mat[i][j] = val;
        return val1 + val;
    }
}