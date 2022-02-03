class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        
        int n = nums1.length;
        HashMap<Long,Integer> p1 = new HashMap<>();
        HashMap<Long,Integer> p2 = new HashMap<>();
        for(int i = 0; i<n; i++)
        {
            for(int j = 0; j<n; j++)
            {
                long h = nums1[i]+nums2[j];
                long h1 = nums4[i]+nums3[j];
                p1.put(h,p1.getOrDefault(h,0)+1);
                p2.put(h1,p2.getOrDefault(h1,0)+1);
            }
        }
        
        int ans = 0;
        for(long j : p1.keySet())
        {
            int g = p2.getOrDefault(-1*j,0);
            ans += g*p1.get(j);
        }
        return ans;
    }
}