class Solution 
{
   
    
     int [][] ans;
     public int minCut(String str)
    {
        int n = str.length();
        boolean [][] dp = new boolean[n][n];
         ans = new int[n][n];
            for(int i = 0; i<n; i++)
        {
            for(int j = 0; j<n; j++)
            {
                ans[i][j] =-1;
            }
        }
        for(int i = 0; i<n; i++)
        { 
            dp[i][i] = true;
            ans[i][i] = 1;
            
        }
         
          
        
         for(int i=0; i<n-1; i++)
         {
             if(str.charAt(i) == str.charAt(i+1))
              { 
                  dp[i][i+1] = true;
                  ans[i][i+1] = 1;
              }
         }
         for(int j = 2; j<n; j++ )
         {
             for(int i= 0; i<n-j; i++)
             {
                 if(str.charAt(i) == str.charAt(i+j) && dp[i+1][i+j-1])
                 {
                     dp[i][i+j]= true;
                     ans[i][i+j] = 1;
                 }
             }
         }
         
         
    
        return call(str,0,n-1,dp)-1;
        
    }
    
     int call(String str , int i, int j , boolean[][] dp)
    {
        if(i > j)
        return 0;
        if(ans[i][j] != -1)
        return ans[i][j];
        
        int an = Integer.MAX_VALUE;
        
        for(int k = i; k<=j; k++)
        {
            if(dp[i][k])
            {
                // System.out.println(str.substring(i,k));
                int val = 1+ call(str,k+1,j,dp);
                an = Math.min(val,an);
            }
        }
        
        return ans[i][j]= an;
    }
    
}