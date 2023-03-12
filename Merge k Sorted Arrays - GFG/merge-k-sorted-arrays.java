//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			Solution T = new Solution();
			ArrayList<Integer> arr= T.mergeKArrays(a, n);
			for(int i = 0; i < n*n ; i++)
			    System.out.print(arr.get(i)+" ");
		    System.out.println();
		    
		    t--;
		}
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int k) 
    {
        // Write your code here.
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<int []> x = new PriorityQueue<>(k,(a,b)->{return Integer.compare(a[0],b[0]);});
        for(int i = 0; i<k; i++)
        x.add(new int[]{arr[i][0],i,0});
        while(!x.isEmpty())
        {
            int [] a = x.poll();
            ans.add(a[0]);
            a[2]++;
            if(a[2] < k)
            {
                x.add(new int[]{arr[a[1]][a[2]],a[1],a[2]});
            }
        }
         
        return ans;
    }
}