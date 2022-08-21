class Solution
{
    public long kSum(int[] nums, int k) 
    {
       PriorityQueue<Long> ans = new PriorityQueue<>();
       long maxsum = 0;
        int n = nums.length;
        for(int i =0; i<nums.length; i++)
        {
            if(nums[i] > 0)
            {
                maxsum+=nums[i];
            }
            else
            {
                nums[i] = nums[i]*-1;
            }
        }
        Arrays.sort(nums);
        ans.add(maxsum);
        PriorityQueue<Pair> x = new PriorityQueue<>((a,b)->{
            return Long.compare(b.sum,a.sum);
        });
        
        x.add(new Pair(0,maxsum-nums[0]));
        while(ans.size() < k)
        {
            Pair p = x.poll();
            ans.add(p.sum);
            if(p.i+1 < n)
            {
              x.add(new Pair(p.i+1, p.sum + nums[p.i] - nums[p.i+1])); 
              x.add(new Pair(p.i+1, p.sum  - nums[p.i+1])); 
            }
        }
        

        
        return ans.peek();
        
    }
    
    class Pair
    {
        int i;
        long sum;
        public Pair(int i, long sum)
        {
            this.i = i;
            this.sum = sum;
        }
    }
}