// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            Solution ob = new Solution();
            
            System.out.println(ob.spanningTree(V, adj));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int v, ArrayList<ArrayList<ArrayList<Integer>>> ada) 
    {
        // Add your code here
        
          ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
          
           for(int i = 0; i<v; i++)
           {
              adj.add(new ArrayList<int []>());              
           }
           for(int i = 0; i<v; i++)
           {
               ArrayList<ArrayList<Integer>> x = ada.get(i);
               for(ArrayList<Integer> p: x)
               adj.get(i).add(new int[]{p.get(0),p.get(1)});
              
           }

          
           int parent[] = new int[v];
           int wt[] = new int[v];

           Arrays.fill(parent,-1);
           Arrays.fill(wt,Integer.MAX_VALUE);

            wt[0] = 0;
           PriorityQueue<Node> p = new PriorityQueue<>((a,b)->{
               return Integer.compare(a.val,b.val);
           });
           boolean [] removed = new boolean[v];
            p.add(new Node(0,0));
          
           while(!p.isEmpty())
           {
               Node minNode = p.poll();
               removed[minNode.pos] = true;
               for(int [] ad : adj.get(minNode.pos))
               {
                   if(!removed[ad[0]] && (wt[ad[0]] ==Integer.MAX_VALUE || wt[ad[0]] > ad[1])  )
                   {
                       p.add(new Node(ad[0],ad[1]));
                       wt[ad[0]] = ad[1];
                       parent[ad[0]] = minNode.pos;
                   }
               }
           }
          
           int total_wt = 0;
           for(int i : wt)
           {
               total_wt+=i;
           }
           return total_wt;

    }
    
   static class Node {
    int pos;
    int val;
    public Node(int pos, int val)
    {
        this.pos = pos;
        this.val = val;
    }
   }
}
