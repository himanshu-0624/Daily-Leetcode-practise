class Solution {
    public List<String> findAndReplacePattern(String[] words, String p) {
        List<String> ans = new  ArrayList<>();
         char [] pa = p.toCharArray();
        for(String s : words)
        {
            char [] a = s.toCharArray();
           
            boolean is = true;
           HashMap<Character, Character> x = new HashMap<>();
           HashMap<Character, Character> y = new HashMap<>();
            for(int i =0; i<a.length; i++)
            {
                if(!x.containsKey(a[i]) && !y.containsKey(pa[i]))
                {
                    x.put(a[i],pa[i]);
                    y.put(pa[i],a[i]);
                }
                else if(x.containsKey(a[i]) && y.containsKey(pa[i]))
                {
                    if(x.get(a[i])!= pa[i] || y.get(pa[i]) != a[i])
                    {
                        is = false;
                        break;
                    }
                }
                else
                {
                    is = false;
                    break;
                }
                    
            }
            if(is)ans.add(s);
        }
        
        return ans;
    }
}