//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine().trim();
            String[] S1 = s1.split(" ");
            int n = Integer.parseInt(S1[0]);
            int k = Integer.parseInt(S1[1]);
            String s2 = br.readLine().trim();
            String[] S2 = s2.split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(S2[i]);
            }
            Solution ob = new Solution();
            boolean ans = ob.canPair(nums, k);
            if (ans)
                System.out.println("True");
            else
                System.out.println("False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public boolean canPair(int[] nums, int k) {
        // Code here
        int [] x = new int[k];
        int n = nums.length;
        if(n%2 !=  0)
        return false;
        for(int i : nums)
        {
            x[i%k]++;
        }
        
        int i = 1;
        int j = k-1;
        boolean ans = true;
        while(i<=j)
        {
            if(i == j)
            {
                if(x[i]%2 != 0)
                  {
                      ans = false;
                  }
                  
            }
            else if(x[i]!=x[j])
            {
                ans  = false;
            }
            i++;
            j--;
        }
        
        return ans;
        
    }
}