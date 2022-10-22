//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.fillingBucket(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int fillingBucket(int n) {
        // code here
        int mod = 1_000_000_00;
        int [] arr = new int[n+1];
        arr[0] = 1;
        arr[1] = 1;
        for(int i = 2; i<=n; i++)
        {
            arr[i] = (arr[i]+arr[i-2])%mod;
            arr[i] = (arr[i]+arr[i-1])%mod;
        }
        return arr[n];
    }
};