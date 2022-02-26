class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int pos[] = new int[n];
        for(int i = 0; i<n; i++)
        {
            // arr[i]--;
            pos[arr[i]] = i;
        }
        int i = 0;
        int ans = 0;
        while(i<n)
        {
            ans++;
            while(true)
            {
                int j = pos[i];
                boolean b = false;
                for(int k = i; k<=j; k++)
                {
                    if(pos[k] > j)
                    {
                        i = k;
                        b = true;
                        break;
                    }
                }
                
                if(!b)
                {
                    i = j+1;
                    break;
                }
            }
            
            
            
        }
        return ans;
    }
}