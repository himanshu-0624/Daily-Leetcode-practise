class Solution {
    int arr[];
    int find(int a)
    {
        if(arr[a] == a)
            return a;
        else
        {
            int c = find(arr[a]);
            arr[a] = c;
            return c;
        }
    }
    void unioun(int a, int b)
    {
           int f1 = find(a);
        int f2  = find(b);
        arr[f1] = f2;
        return;
    }
    public int findCircleNum(int[][] is) {
        int n = is.length;
        arr = new int[n];
        for(int i = 0; i<n; i++)
            arr[i] = i;
        
        for(int i = 0; i<n; i++)
        {
            for(int j = 0; j<n; j++)
            {
                if(is[i][j] == 1)
                {
                    int a = find(i);
                    int b=  find(j);
                    if(a != b)
                    unioun(i,j);
                }
            }
        }
        for(int i = 0; i<n; i++)
        {
            int aa = find(i);
        }
            
        
        HashSet<Integer> x = new HashSet<>();
        for(int y : arr)
            x.add(y);
            return x.size();
    }
}