class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> a = new ArrayList<>();
        int i =0;
        while(i<nums.length)
        {
            int j = i+1;
            while(j<nums.length && nums[j-1]+1 == nums[j])
            {
                j++;
            }
            StringBuffer u = new StringBuffer();
            u.append(nums[i]);
            if(j==i+1)
            {
                a.add(u.toString());
            }
            else{
                u.append("->"+nums[j-1]);
                                a.add(u.toString());
                
            }
            i = j;
        }
        return a;
    }
}