//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
        // Your code here
        int [] x = new int[26];
        int n = s.length();
        int m = p.length();
        int ans = -1;
        int size = n+1;
        for(int i = 0; i<m; i++)
        {
            x[p.charAt(i)-'a']++;
        }
        
        int [] cnt = new int[26];
        int k = 0;
        for(int i = 0; i<n; i++)
        {
           cnt[s.charAt(i)-'a']++;
           if(check(cnt,x))
           {
               k = call(cnt,x,k,s);
               if(i-k+1 < size)
               {
                   size = i-k+1;
                   ans = k;
               }
           }
        }
        
        if(ans == -1)
        return "-1";
        return s.substring(ans,ans+size);
        
         
    }
    
    static boolean check(int [] a, int [] b)
    {
        for(int i = 0; i<26; i++)
        {
            if(a[i] < b[i])
            return false;
        }
        
        return true;
    }
   

    static int call(int [] a, int [] b, int i,String s)
    {
        while(i<s.length() && a[s.charAt(i)-'a'] > b[s.charAt(i)-'a'] )
        {
            a[s.charAt(i)-'a']--;
            i++;
        }
        return i;
         
    }
   

    
    
}