class Solution {
    public int maxArea(int[] height) {
         int n=height.length;
         long maxn=0;
         int i=0;
         int j=height.length-1;
        
        while(j>i)
        {
            if(height[i]>height[j])
            {
                long  k=height[j];
                maxn= Math.max(maxn,Math.abs(j-i)*k);
                j--;
            }
            else
            {
                 long  k=height[i];
                 maxn=Math.max(maxn,Math.abs(j-i)*k);
                i++;
            }
                
        }
        return (int)maxn;
    }
}