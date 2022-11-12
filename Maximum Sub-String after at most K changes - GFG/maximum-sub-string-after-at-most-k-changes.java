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
            String s = br.readLine().trim();
            int k = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.characterReplacement(s, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int characterReplacement(String s, int k)
    {
        // code here
       
        int ans = k+1;
        int n = s.length();
         for(int i  = 0; i<26; i++)
         {
             char c  = (char)(i+'A');
                 int j = 0;
                 int cnt = 0;
              for(int ii = 0; ii<n; ii++)
              {
                    if(s.charAt(ii) != c)
                    {
                        cnt++;
                    }
                    
                     while(j<=ii && cnt > k )
                     {
                         if(s.charAt(j) != c)
                         {
                            cnt--;
                          }
                        j++;
                     }
                     
                    
                   ans = Math.max(ans,ii-j+1);   
                     
              
              }
         }
             
         
         
         return ans;
    }
}