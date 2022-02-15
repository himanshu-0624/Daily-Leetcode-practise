// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] cost = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    cost[i][j] = Integer.parseInt(S[j]);
            }
            Solution obj = new Solution();
            int ans = obj.total_cost(cost);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int total_cost(int[][] cost)
    {
        // Code here 
        int n = cost.length;
        if (n == 1)return 0;
        int val = call(cost,0,new boolean[n],n);
        return val;
    }
    
    int call(int cost[][], int i, boolean vis[], int n)
    {
        vis[i] = true;
        int ans = Integer.MAX_VALUE;
        boolean  dd = true;
        for(int j = 0; j<n; j++)
        {
            if(!vis[j] && cost[i][j]!=0)
            {
                dd = false;
                ans  = Math.min(ans,cost[i][j]+call(cost,j,vis,n));
                
            }
        }
         vis[i] = false;
        if(dd)
        {
            if(cost[i][0] != 0)
            {
                return cost[i][0];
            }
        }
        return ans;
       
        
    }
}