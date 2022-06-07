class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int p[] = new int[n+m];
        int k = 0;
        while(i<m || j<n)
        {
            int a = i<m ? nums1[i] : Integer.MAX_VALUE;
             int b = j<n ? nums2[j] : Integer.MAX_VALUE;
            
            if(a>b)
            {
                p[k++]=b;
                j++;
            }
            else
            {
                p[k++] = a;
                i++;
            }
        }
        
        int l = 0;
        for( i = 0; i<m+n; i++)
        {
            nums1[i] = p[l++];
        }
        // for(i = 0; i<n; i++)
        // {
        //     nums2[i] = p[l++];
        // }
    }
}