class Solution 
{
    
    public boolean equationsPossible(String [] equations) 
    {
        int par[] = new int[26];
        for(int i = 0; i<26; i++)
            par[i] = -1;
        
        ArrayList<Integer> x = new ArrayList<>();
        for(String a : equations)
        {
            int a1  = a.charAt(0)-'a';
            int a2  = a.charAt(3)-'a';
            if(a.charAt(1) == '!')
            {
                x.add(a1);
                x.add(a2);
            }
            else
            {
                union(par,a1,a2);
            }
            
        }
        
        for(int i = 0; i<x.size(); i+=2)
        {
            int p = find(par,x.get(i));
            int q = find(par,x.get(i+1));
            if(p == q)
                return false;
        }
        
        return true;
    }
    
    void union(int [] par,int i, int j)
    {
        int a  = find(par,i);
        int b  = find(par,j);
        if(a != b)
        {
             par[a] = b;
        }
       
    }
    
    int find(int [] par, int i)
    {
        if(par[i] == -1)
            return i;
        return par[i] = find(par,par[i]);
    }
}