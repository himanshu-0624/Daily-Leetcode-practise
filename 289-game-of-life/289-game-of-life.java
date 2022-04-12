class Solution {
    public void gameOfLife(int[][] b) {
        int n = b.length;
        int m = b[0].length;
        int ans[][] = new int[n][m];
        for(int i = 0; i<n; i++)
        {
            for(int j = 0; j<m; j++)
            {
                ans[i][j] = b[i][j];
            }
        }
        
        for(int i = 0; i<n; i++)
        {
            for(int j = 0; j<m; j++)
            {
                int c = cnt(ans,i,j,n,m);
               if(ans[i][j] == 0)
               {
                   if(c == 3)
                   {
                       b[i][j] = 1;
                   }
               }
               else
               {
                 if(c == 2 || c == 3)
                 {
                     
                 }
                   else
                   {
                       b[i][j] = 0;
                   }
               }
            }
        }
        
       
        
    }
    
    int cnt(int [][] g, int i, int j, int n, int m)
    {
        int ans = 0;
        if(i+1 < n )
        {
            ans+=g[i+1][j];
            
        }
         if(i-1 >= 0)
        {
            ans+=g[i-1][j];
            
        }
         if(i-1 >= 0 && j-1 >=0 )
        {
            ans+=g[i-1][j-1];
            
        }
         if(i+1 <n && j+1 <m)
        {
            ans+=g[i+1][j+1];
            
        }
         if(j+1 <m)
        {
            ans+=g[i][j+1];
            
        }
         if(j-1 >= 0)
        {
            ans+=g[i][j-1];
            
        }
        
         if(i-1 >= 0 && j+1 <m)
        {
            ans+=g[i-1][j+1];
            
        }
         if(i+1 <n && j-1 >= 0)
        {
            ans+=g[i+1][j-1];
            
        }
        
        return ans;
    }
    
}