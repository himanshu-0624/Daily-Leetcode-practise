//{ Driver Code Starts
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
            String s = br.readLine().trim();
            String[] S = s.split(" ");
            int[] capacity = new int[n];
            for(int i = 0; i < n; i++)
                capacity[i] = Integer.parseInt(S[i]);
            Solution ob = new Solution();
            int ans = ob.totalWays(n, capacity);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int totalWays(int n, int [] cap) 
    {
         int mod = 1_000_000_007;
         Arrays.sort(cap);
         long ans = 1;
         for(int i = 0; i<n; i++)
         {
             ans = (ans%mod*((cap[i]-i)%mod))%mod;
             if(ans <=0)
             return 0;
         }
         return (int)ans%mod;
         
    }
}