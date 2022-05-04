class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i: nums)
        {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        
        int ans = 0;
        
        for(int i : map.keySet())
        {
            if(2*i != k && map.containsKey(k-i))
            {
                ans+=Math.min(map.get(i),map.get(k-i));
                map.put(i,0);
                map.put(k-i,0);
            }
            else if(2*i == k)
            {
                ans+=(map.get(i)/2);
            }
        }
        
        return ans;
    }
}