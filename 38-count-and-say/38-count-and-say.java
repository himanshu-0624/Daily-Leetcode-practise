class Solution {
    public String countAndSay(int n) {
        ArrayList<Character> x = new ArrayList<>();
        x.add('1');
        x = call(x,n);
        
        StringBuffer ans = new StringBuffer();
        for(char c: x)
        {
            ans.append(c);
        }
        return ans.toString();
    }
    
    ArrayList<Character> call(ArrayList<Character> p, int l)
    {
        if(l == 1)
            return p;
        
        int i = 0;
        int n = p.size();
        ArrayList<Character> d1 = new ArrayList<>();
        while(i<n)
        {
            int j = i+1;
            int cnt = 1;
            while(j<n && p.get(i) == p.get(j))
            {
                j++;
                cnt++;
            }
            ArrayList<Character> g = new ArrayList<>();
            while(cnt>0)
            {
                char t = (char)((cnt%10)+'0');
                g.add(t);
                cnt/=10;
            }
            for(int k = g.size()-1; k>=0; k--)
            {
                d1.add(g.get(k));
            }
            d1.add(p.get(i));
            i=j;
        }
        return call(d1,l-1);
    }
}