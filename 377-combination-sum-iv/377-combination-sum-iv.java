class Solution {
    
    public int combinationSum4(int[] arr, int t) {
           int n = arr.length;
           int dp[] = new int[t+1];
        dp[0] = 1;
        for(int i = 1; i<=t; i++)
        {
            for(int j = 0; j<n; j++)
            {
                if(i-arr[j]>=0)
                dp[i]+=dp[i-arr[j]];
            }
        }
        return dp[t];
        
    }
       
        
    }