//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int v, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        ArrayList<ArrayList<Integer>> tadj = new ArrayList<>();
        for(int i = 0; i<v; i++)
        {
            tadj.add(new ArrayList<>());
        }
        
        for(int i = 0; i<v; i++)
        {
            ArrayList<Integer> a = adj.get(i);
            for(int j  : a)
            {
                tadj.get(j).add(i);
            }
        }
        
        Stack<Integer> x = new Stack<>();
        boolean [] vis = new boolean[v];
        for(int i = 0; i<v; i++)
        {
            dfs(adj,i,x,vis);
        }
        int cnt = 0;
        vis = new boolean[v];
        while(!x.isEmpty())
        {
            int i= x.pop();
            if(!vis[i])
            {
                cnt++;
                dfs1(tadj,i,x,vis);
                
            }
            
        }
        return cnt;
    }
    
    
    void dfs1(ArrayList<ArrayList<Integer>> adj , int i, Stack<Integer> x, boolean [] vis)
    {
        if(vis[i])
        return;
        vis[i] = true;
        for(int j : adj.get(i))
        {
            dfs1(adj,j,x,vis);
        }
        
        // x.add(i);
    }
    
    void dfs(ArrayList<ArrayList<Integer>> adj , int i, Stack<Integer> x, boolean [] vis)
    {
        if(vis[i])
        return;
        vis[i] = true;
        for(int j : adj.get(i))
        {
            dfs(adj,j,x,vis);
        }
        
        x.add(i);
    }
}
