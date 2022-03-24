class Solution {
    public int numRescueBoats(int[] arr, int l) {
        Arrays.sort(arr);
        int i = 0; int j = arr.length-1;
        int ans =0;
        while(i<=j)
        {
           if(i == j)
           {
            ans++;
               break;
           }
            if(arr[i]+arr[j]<=l)
            {
                ans++;
                i++;
                j--;
            }
            else
            {
                ans++;
                j--;
            }
                
            
        }
        return ans;
    }
}