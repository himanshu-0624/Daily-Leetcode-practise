class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        int n = nums.length;
        if(n == 1)return;
          while(i>=0 && nums[i] >= nums[i+1] )i--;
            
        if(i>= 0)
        {
            int j = n-1;
            while(nums[i] >= nums[j] )j--;
            swap(nums,i,j);
        }
        
        reverse(nums,i+1);
    }
    void swap(int arr[], int i, int j)
    {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    void reverse(int arr[], int i)
    {
        int j = arr.length-1;
        while(i<j)
        {
            swap(arr,i,j);
            i++;
            j--;
        }
        
    }
}