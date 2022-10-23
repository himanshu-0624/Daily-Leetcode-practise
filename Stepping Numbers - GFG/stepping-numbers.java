//{ Driver Code Starts
//Initial Template for Java


//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int  N = Integer.parseInt(input_line[0]);
            int  M = Integer.parseInt(input_line[1]);
            
            Solution ob = new Solution();
            int ans = ob.steppingNumbers(N, M);
            System.out.println(ans);
        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution{
    int steppingNumbers(int n, int m){
        // code here
        int ans1 = 0;
        int ans2 = 0;
        for(int i = 1; i<=9; i++)
        {
            ans1+=(call(n-1,i));
            ans2+=(call(m,i));
        }
        
        if(n == 0)
        return ans2+1;
        return ans2 - ans1;
        
    }
    
    int call(int v, int i)
    {
       if(v < i)
       return 0;
       int a = i%10;
       if(a  == 0)
       {
            return 1 + call(v,i*10 + (a+1));
       }
       if(a == 9)
       {
            return 1 + call(v,i*10 + (a-1));
       }
       return 1 + call(v,i*10 + (a+1)) + call(v,i*10 + (a-1)); 
    }
}
