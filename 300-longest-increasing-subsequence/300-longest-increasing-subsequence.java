class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> x = new ArrayList<>();
        
        for(int i = 0; i<nums.length; i++)
        {
            call(x,nums[i]);
        }
       
        return x.size();
    }
    
    void call(ArrayList<Integer> x, int val)
    {
        int i = 0;
        int j = x.size()-1;
        if(j == -1)
        {
            x.add(val);
            return;
        }
        if(x.get(j) < val)
        {
            x.add(val);
            return;
        }
        
        int pos = -1;
        while(i<=j)
        {
            int mid = i+ (j-i)/2;
            if(x.get(mid) >= val)
            {
                pos = mid;
                j = mid-1;
            }
            else
            {
                // pos = mid;
                i = mid+1;
            }
        }
        
        if(pos != -1)
        x.set(pos,val);
    }
}