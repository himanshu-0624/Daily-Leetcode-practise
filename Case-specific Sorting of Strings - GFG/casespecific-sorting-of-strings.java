//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
    //Function to perform case-specific sorting of strings.
    public static String caseSort(String str)
    {
        // Your code here
       int [] x1 = new int[26];
       int [] x2 = new int[26];
      
        for(char c : str.toCharArray())
        {
            if(Character.isLowerCase(c))
            {
                x1[c-'a']++;
            }
            else 
            {
                x2[c-'A']++;
            }
        }
       
        StringBuffer ans = new StringBuffer();
        int i = 0;
        int j = 0;
         for(char c : str.toCharArray())
        {
            if(Character.isLowerCase(c))
            {
                while(x1[j] == 0)
                j++;
                char d = (char)('a'+j);
                ans.append(d);
                x1[j]--;
            }
            else 
            {
                 while(x2[i] == 0)
                i++;
                char d = (char)('A'+i);
                ans.append(d);
                x2[i]--;
            }
        }
        
        return ans.toString();
    }
}

//{ Driver Code Starts.

class GFG {
	public static void main (String[] args) {
		
    	try {
    	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	    PrintWriter out=new PrintWriter(System.out);
    	    String[] words = br.readLine().split("\\s+");
    	    int numTestCases = Integer.parseInt(words[0]);
    	    
    	    for (int tIdx = 0; tIdx < numTestCases; tIdx++) {
    	        words = br.readLine().split("\\s+");
    	        int size = Integer.parseInt(words[0]);
    	        String str = br.readLine();
    	        String sortedStr = new Solution().caseSort(str);
    	        out.println(sortedStr);
    	    }
    	    out.close();
    	}
    	catch (IOException e) {
    	    System.out.println(e);
    	}
	}
}
// } Driver Code Ends