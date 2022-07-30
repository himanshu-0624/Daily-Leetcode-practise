class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int [] x = new int[26];
        // Arrays.fill(x,Integer.MAX_VALUE);
        List<String> ans = new ArrayList<>();
        for(String a : words2)
        {
           int [] p = new int[26];
            for(char v : a.toCharArray())
            {
                p[v-'a']++;
            }
            
            for(int i = 0; i<26; i++)
                x[i] = Math.max(x[i],p[i]);
            
        }
        
        for(String a : words1)
        {
            int [] p = new int[26];
            for(char v : a.toCharArray())
            {
              
                p[v-'a']++;
            }
            boolean f = true;
              for(int i = 0; i<26; i++)
                if(p[i] < x[i])
                {
                    f = false;
                    break;
                }
            
            if(f)
                ans.add(a);
            
        }
        
        return ans;
    }
}