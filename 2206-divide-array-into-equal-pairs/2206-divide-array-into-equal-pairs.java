class Solution {
    public boolean divideArray(int[] nums) {
        int [] f = new int[501];
        for(int i : nums)
        {
            f[i]++;
        }
        for(int j :  f)
        {
            if(j%2 != 0)
                return false;
        }
        
        return true;
    }
}