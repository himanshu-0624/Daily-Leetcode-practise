class Solution {
    public boolean searchMatrix(int[][] ma, int tar) {
        int i = 0;
        int j = ma.length-1;
        int m = ma[0].length-1;
        while(i<=j)
        {
          // System.out.println(i+" "+j);
            int mid = (i+j)/2;
            if(ma[mid][0] > tar)
            {
                j = mid-1;
            }
            else if(ma[mid][m] < tar)
            {
                i = mid+1;
            }
            else {
                int a = 0;
                int b = m;
                while(a<=b)
                {
                   // System.out.println(a+" "+b);
                    int k = (a+b)/2;
                    if(ma[mid][k] == tar)return true;
                    else if(ma[mid][k] > tar)
                    {
                        b = k-1;
                    }
                    else
                    {
                        a = k+1;
                    }
                }
                return false;
            }
        }
        return false;
        
    }
}