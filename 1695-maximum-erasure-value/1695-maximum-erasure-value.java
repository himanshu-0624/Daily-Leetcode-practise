class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int max = 0;
        int sum = 0;
        HashMap<Integer,Integer> x = new HashMap<>();
        int n = nums.length;
        int j = 0;
        for(int i = 0; i<n; i++)
        {
            if(x.containsKey(nums[i]))
            {
                while(x.containsKey(nums[i]))
                {
                    x.remove(nums[j]);
                    sum-=nums[j];
                    j++;
                }
            }
            // else
            {
                x.put(nums[i],1);
                sum+=nums[i];
                max = Math.max(max,sum);
            }
        }
        
        return max;
    }
}