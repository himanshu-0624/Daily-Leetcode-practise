class Solution {
    public int[] sortEvenOdd(int[] nums) {
        ArrayList<Integer> x = new ArrayList<>();
          ArrayList<Integer> x1 = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i<n; i++)
        {
            if(i%2 == 0)
                x.add(nums[i]);
            else 
                x1.add(nums[i]);
        }
        Collections.sort(x);
            Collections.sort(x1,(a,b)->{
                return Integer.compare(b,a);
            });
        int a1 = 0;
        int a2 = 0;
        for(int i = 0; i<n; i++)
            
        {
             if(i%2 == 0)
                nums[i]= x.get(a1++);
            else 
                nums[i] = x1.get(a2++);
        }
        return nums;
    }
}