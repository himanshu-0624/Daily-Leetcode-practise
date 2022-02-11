// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            
            System.out.println(ob.countWays(n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    int countWays(int n) {
        // code here
        long ecnt = n/2;
        long ocnt = n/2+n%2;
        
          long ans = 0;
          long mod = 1_000_000_007;
        if(ecnt >=3)
        {
              ans+= (ecnt*(ecnt-1))/2;
               ans*=(ecnt-2);
                ans/=3;
              ans%=mod;
             
            //   ans%=mod;
             
        }
        long p = 0;
         if(ocnt >=2)
        {
             p = ((ocnt)*(ocnt-1))/2;
             p%=mod;
             p*=ecnt;
             p%=mod;
        }
        ans = (ans+p)%mod;
        return (int)ans;
    }
};