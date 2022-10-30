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
            int N = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            long ans = obj.NoOfChicks(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public long NoOfChicks(int n)
    {
        // Code here
        ArrayList<Long> ans = new ArrayList<>();
        ans.add(1l);
        for(int i = 1; i<n; i++)
        {
             ArrayList<Long> ans1 = new ArrayList<>(); 
             long p = 0;
             if(ans.size() != 6)
             for(int j = 0; j<ans.size(); j++)
             {
                 p = p + ans.get(j)*2;
                 
             }
             else
             for(int j = 1; j<ans.size(); j++)
             {
                 p = p + ans.get(j)*2;
                 
             }
             
             if(ans.size() == 6)
             {
                 for(int j = 1; j<6; j++)
                 ans1.add(ans.get(j));
             }
             else
             {
                 for(long j : ans)
                 {
                     ans1.add(j);
                 }
             }
             ans1.add(p);
             ans = ans1;
             
        }
        long a = 0;
        for(long e : ans)
        a+=e;
        return a;
    }
}