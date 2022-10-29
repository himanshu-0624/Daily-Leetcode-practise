//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String contact[] = in.readLine().trim().split("\\s+");
            String s = in.readLine();
            
            Solution ob = new Solution();
            ArrayList<ArrayList<String>> ans = ob.displayContacts(n, contact, s);
            for(int i = 0;i < ans.size();i++){
                for(int j = 0;j < ans.get(i).size();j++)
                    System.out.print(ans.get(i).get(j) + " ");
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static ArrayList<ArrayList<String>> displayContacts(int n, String contact[], String s)
    {
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        
        Trie t = new Trie();
        for(String a : contact)
        {
            t.add(a.toCharArray());
        }
        
        for(int i = 0; i<s.length(); i++)
        {
            ans.add(t.call(s.substring(0,i+1)));
        }
        
        return ans;
    }
    
    static class Node
    {
        int cnt;
        Node [] x;
        
        public Node()
        {
            x = new Node[26];
        }
    }
    
    static class Trie
    {
        Node root;
        public Trie()
        {
            root = new Node();
        }
        
        void add(char [] x)
        {
            Node p = root;
            for(char c : x)
            {
                if(p.x[c-'a']!=null)
                {
                    p = p.x[c-'a'];
                }
                else
                {
                    p.x[c-'a'] = new Node();
                    p = p.x[c-'a'];
                }
            }
            
            p.cnt++;
        }
        
        ArrayList<String> call(String a)
        {
            ArrayList<String> ans = new ArrayList<>();
            
            Node p = root;
            for(char c : a.toCharArray())
            {
                if(p.x[c-'a']!=null)
                {
                    p = p.x[c-'a'];
                }
                else
                {
                    p =null;
                   break;
                }
            }
            
            if(p == null)
            {
                ans.add("0");
                return ans;
            }
            
            call1(ans,a,p);
            return ans;
        }
        
        void call1(ArrayList<String> ans,String a, Node p)
        {
            if(p.cnt > 0 )
            {
                ans.add(a);
            }
            
            for(int i = 0; i<26; i++)
            {
                if(p.x[i] != null)
                {
                    char c = (char)(i+'a');
                    
                    call1(ans,a+(c),p.x[i]);
                }
            }
            
            return;
        }
    }
}