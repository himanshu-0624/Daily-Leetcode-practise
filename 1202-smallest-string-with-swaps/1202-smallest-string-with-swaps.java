class Solution {
    int dsu[];
    
    int find(int a)
    {
        if(dsu[a] == -1)
            return a;
        return dsu[a] = find(dsu[a]);
     }
    
    void union(int a, int b)
    {
        int x = find(a);
        int y = find(b);
        if(x != y)
        {
            dsu[x] = y;
        }
    }
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        dsu = new int[n];
        Arrays.fill(dsu,-1);
        
        char [] x = s.toCharArray();
        for(List<Integer> pair : pairs)
        {
            union(pair.get(0),pair.get(1));
        }
        HashMap<Integer,ArrayList<Integer>> map1 = new HashMap<>();
        HashMap<Integer,int [] > map2 = new HashMap<>();
        for(int i = 0; i<n; i++)
        {
            int par = find(i);
            if(!map1.containsKey(par))
            {
               map1.put(par,new ArrayList<Integer>());
               map2.put(par,new int[26]); 
            }
             map1.get(par).add(i);
             map2.get(par)[x[i]-'a']++;
            
        }
        
        for(int key :  map1.keySet())
        {
            ArrayList<Integer> pos = map1.get(key);
            int arr[] = map2.get(key);
            Collections.sort(pos);
            int j = 0;
            int size = pos.size();
            for(int i = 0; i<26; i++)
            {
                char p = (char)(i+'a');
                while(j<size && arr[i]> 0)
                {
                    x[pos.get(j)] = p;
                    j++;
                    arr[i]--;
                }
                if(j == size)
                    break;
            }
        }
        
        StringBuffer ans = new StringBuffer();
        for(char c: x)
            ans.append(c);
        
        return ans.toString();
        
    }
    
    
}