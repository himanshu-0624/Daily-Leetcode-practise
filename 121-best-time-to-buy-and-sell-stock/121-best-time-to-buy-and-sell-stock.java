class Solution {
    public int maxProfit(int[] pr) {
        int n = pr.length;
       int maxp = 0;
        
        int min = pr[0];
        for(int i = 1; i<n ; i++)
        {
           
            
            maxp = Math.max(maxp,pr[i] - min);
            min = Math.min(min,pr[i]);
        }
        
        return maxp;
    }
}