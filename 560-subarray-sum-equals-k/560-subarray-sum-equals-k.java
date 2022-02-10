class Solution {
    public int subarraySum(int[] nums, int k) {
      int ans = 0;
        HashMap<Integer,Integer> x = new HashMap<>();
        x.put(0,1);
        int c = 0,sum = 0;
        
        for(int i = 0; i<nums.length; i++)
        {
              sum+=nums[i];
               if(x.containsKey(sum-k))
               {
                   c+=x.get(sum-k);
               }
           x.put(sum, x.getOrDefault(sum, 0) + 1); 
        }
        return c;
    }
}