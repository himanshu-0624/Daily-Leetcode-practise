class Solution {
    HashMap<String, Integer> ans;
    public int longestStrChain(String[] words) {
        ans = new HashMap<>();
        for(String w : words)
        {
            ans.put(w,-1);
        }
        Arrays.sort(words,(a,b)->{
            return Integer.compare(a.length(),b.length());
        });
        
        int max = 0;
        for(String w : words)
        {
           int p = call(w);
           ans.put(w,p);
            max = Math.max(p,max);
        }
        return max;
    }
    
    int call(String w)
    {
        if(ans.get(w) != -1)
            return ans.get(w);
        int an = 0;
        for(int i = 0; i<w.length(); i++)
        {
           
                String d  = w.substring(0,i)+w.substring(i+1,w.length());
                
                if(ans.containsKey(d))
                an = Math.max(call(d),an);
            
        }
        return an+1;
        
    }
}