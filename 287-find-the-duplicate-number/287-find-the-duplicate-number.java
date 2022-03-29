class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        //1 <= x <=n
        
        boolean arr[] = new boolean[n+1];
        Arrays.fill(arr,false);
        
        for(int i : nums)
        {
            if(arr[i])
            {
                return i;
            }
            else 
            {
                arr[i] = true;
            }
        }
        
        return -1;
    }
}