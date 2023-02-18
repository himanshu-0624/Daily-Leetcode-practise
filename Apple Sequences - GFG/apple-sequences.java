//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            String arr = read.readLine().trim();

            Solution ob = new Solution();
            out.println(ob.appleSequence(N, M, arr));
        }
        out.close();
    }
}


// } Driver Code Ends
//User function Template for Java


class Solution{
    public static int appleSequence(int n, int m, String arr){
        //code here
        int ans = m;
        int i = 0;
        int j = 0;
        int cnt = 0;
        while(i<n)
        {
            while(i<n && (arr.charAt(i) == 'A' || cnt < m))
            {
              
                if(arr.charAt(i) == 'O')
                cnt++;
                  i++;
            }
            
            ans = Math.max(ans,i-j);
            while(j<n && cnt >= m )
            {
                if(arr.charAt(j) == 'O')
                {
                    cnt--;
                    
                }
                j++;
            }
        }
        
        return ans;
    }
}


//{ Driver Code Starts.

// } Driver Code Ends