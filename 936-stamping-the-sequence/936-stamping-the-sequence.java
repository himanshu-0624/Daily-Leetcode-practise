class Solution {
    public int[] movesToStamp(String stamp, String target) {
        Stack<Integer> x = new Stack<>();
        char [] a = target.toCharArray();
        char [] b = stamp.toCharArray();
        boolean ans = call(a,b,x);
        if(ans)
        {
            int n = x.size();
            int arr[] = new int[n];
            int i = 0;
            while(!x.isEmpty())
            {
                arr[i++] = x.pop();
            }
            
            return arr;
        }
        return new int[0];
        
    }
    
    boolean call(char [] a, char [] b, Stack<Integer> x)
    {
        int n = a.length;
        int m = b.length;
        
        int i = 0;
        int cnt = 0;
        while(i<n)
        {
            int j = i;
            int p = 0;
            boolean f = false;
            while(p < m && j< n && (a[j] == '?' ||  a[j] == b[p]))
            {
                if(a[j] != '?')
                    f = true;
                p++;
                j++;
                
            }
            
            if(p != m || !f)
            {
               i++; 
            }
            else
            {
                x.add(i);
                
                while(i<j)
                {
                    a[i++] = '?';
                }
                cnt++;
            }
        }
        
        if(cnt > 0)
        {
            for(char c : a)
            {
                if(c != '?')
                {
                    return call(a,b,x);
                }
            }
            
            return true;
        }
        else
            return false;
    }
}