//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            
            Solution ob = new Solution();
            System.out.println(ob.minFind(n, a));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int minFind(int n, String a[]){
        // code here
        int cntR=0, cntG=0, cntB=0;
        for(String color : a){
            if(color.equals("R")) cntR++;
            else if(color.equals("G")) cntG++;
            else cntB++;
        }
        if(cntR==n || cntG==n || cntB==n) return n;
        if((cntR%2==cntG%2) && (cntG%2==cntB%2)) return 2;
        return 1;
    }
}