//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().convert(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    void convert(int[] arr, int n) {
        //Code here
        ArrayList<int[]> x =new ArrayList<>();
        for(int i = 0; i<n; i++)
        {
            int []p =new int[2];
            p[0] = arr[i];
            p[1] = i;
            x.add(p);
        }
        
        Collections.sort(x,(a,b)->{return Integer.compare(a[0],b[0]);});
        int i = 0;
        for(int [] p : x)
        {
            arr[p[1]] = i;
            i++;
        }
        
    
        
    }
}