class Solution {
    public int findMaxLength(int[] nums) {
        int max =0;
        HashMap<Integer,Integer> x = new HashMap<>();
        x.put(0,-1);
        int s = 0;
        for(int i = 0; i<nums.length; i++)
        {
            if(nums[i] == 0)
            {
                s-=1;
            }
            else
            {
                s+=1;
            }
            if(x.containsKey(s))
            {
                max = Math.max(i-x.get(s),max);
            }
            else
                
                x.put(s,i);
        }
        return max;        
    }
}