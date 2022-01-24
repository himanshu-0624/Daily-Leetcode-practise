class Solution {
    public int numberOfArrays(int[] diff, int low, int upp) {
        int n = diff.length;
        long [] gg = new long[n+1];
        long max = 0;
        long min = 0;
        for(int i = 0; i<n; i++)
        {
            gg[i+1] = gg[i]+diff[i];
            max = Math.max(gg[i+1],max);
            min = Math.min(gg[i+1],min);
        }
        long h = upp - low;
        if(max-min <= h)
        {
            
            return (int)(h-(max-min)+1);
        }
        else
            return 0;
        
    }
}