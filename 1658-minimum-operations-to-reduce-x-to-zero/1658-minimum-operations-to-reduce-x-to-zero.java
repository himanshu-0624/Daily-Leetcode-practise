class Solution {
    public int minOperations(int[] nums, int x) {
        HashMap<Integer,Integer> map = new HashMap<>();
         if(x == 0)        
        return x;
        int sum = 0;
        for(int i :  nums)
        {
            sum+=i;
        }
        int max = -1;
        int d = 0;
        map.put(d,-1);
        for(int i = 0; i<nums.length; i++)
        {
            d+=nums[i];
            if(!map.containsKey(d))
            {
                map.put(d,i);
            }
            if(map.containsKey(d- (sum-x)))
            {
                int pos = map.get(d- (sum-x));
                max = Math.max(max,i-pos);
            }
        }
        if(max == -1)return max;
        return nums.length-max;
        
    }
}