class Solution 
{
    int [][] dp;
    public int maxCoins(int[] nums)
    {
        int n = nums.length;
        dp = new int[n][n];
        for(int i = 0; i<n; i++)
        {
            for(int j = 0; j<n; j++)
                dp[i][j] = -1;
        }
        return solve(nums,0,n-1,1,1);
    }
    
    int solve(int [] arr , int i, int j, int l , int r)
    {
        if(i>j)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        int ans = Integer.MIN_VALUE;
        for(int k = i; k<=j; k++)
        {
            int val = l*arr[k]*r + solve(arr,i,k-1,l,arr[k]) + solve(arr,k+1,j,arr[k],r);
            ans = Math.max(ans,val);
        }
        
        return dp[i][j]  = ans;
    }
}
