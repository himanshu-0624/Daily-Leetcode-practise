class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int [] prr = new int[nums.length];
        for(int i = 0; i<nums.length; i++)
        {
            prr[i] = nums[i];
        }
        Arrays.sort(prr);
        int a = -1;
        for(int i = 0; i<nums.length; i++)
        {
            if(prr[i] != nums[i])
            {
                a = i;
                break;
            }
        }
        int b = -1;
        for(int i = nums.length-1; i>=0; i--)
        {
            if(prr[i] != nums[i])
            {
                b = i;
                break;
            }
        }
        if(b < 0)return 0;
        return (b-a+1);
    }
}