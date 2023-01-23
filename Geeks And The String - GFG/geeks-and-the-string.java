//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String s; 
            s = br.readLine();
            
            Solution obj = new Solution();
            String res = obj.removePair(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static String removePair(String s) {
        // code here
        Stack<Character> x = new Stack<>();
        for(char c :  s.toCharArray())
        {
            if(!x.isEmpty() && x.peek() == c)
            {
                x.pop();
            }
            else
            x.add(c);
        }
        
        StringBuffer ans = new StringBuffer();
        for(char c : x)
        ans.append(c);
        if(ans.length() == 0)
        return "-1";
        else
        return ans.toString();
    }
}
        
