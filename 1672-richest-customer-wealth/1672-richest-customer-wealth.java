class Solution {
    public int maximumWealth(int[][] acc) {
        int max = 0;
        for(int [] a : acc)
        {
            int d = 0;
            for(int p : a)
            {
                d+=p;
            }
            max = Math.max(d,max);
        }
        
        return max;
    }
}