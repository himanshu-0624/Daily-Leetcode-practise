class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        long [] val = new long[n];
        
        for(int i = 0; i<n; i++)
        {
            for(char c : words[i].toCharArray())
            {
                int pos = c - 'a';
                long h = 1<<pos;
                val[i] = (val[i]|h);
            }
        }
        
        int ans = 0;
        for(int i = 0; i<n; i++)
        {
            int v1 = words[i].length();
            for(int j = i+1; j<n; j++)
            {
                int v2 = words[j].length();
                
                if((val[i]&val[j]) == 0)
                {
                  ans = Math.max(ans,v1*v2);   
                }
            }
        }
        
        return ans;
    }
}