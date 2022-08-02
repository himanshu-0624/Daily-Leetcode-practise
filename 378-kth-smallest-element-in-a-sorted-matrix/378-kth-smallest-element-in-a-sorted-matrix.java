class Solution {
    int [][] m;
    int n;
    int[] ans;
    public int kthSmallest(int[][] mat, int k) {
        m = mat;
        n = mat.length;
        ans = new int [1];
        ans[0] = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++)
        {
            pass(i);
        }
        return ans[k];
        
    }
    void pass(int k)
    {
        int [] arr = new int[n+ans.length];
        int i = 0;
        int j = 0;
        int p = 0;
        while(i<n && j<ans.length)
        {
            if(m[k][i] > ans[j])
            {
                arr[p]  = ans[j++];
            }
            else
            {
                arr[p] = m[k][i++];
            }
            p++;
        }
        while(j<ans.length)
        {
            arr[p++]  = ans[j++];
        }
        while(i<n)
        {
            arr[p++]  = m[k][i++];
        }
       ans = arr;
    }
}