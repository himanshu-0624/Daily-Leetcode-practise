class Solution {
    public int largestRectangleArea(int[] h) {
         int n = h.length;
        int left[] = new int[n];
        int right[]  = new int[n];
        Stack<Integer> x = new Stack<>();
        for(int i = n-1; i>=0; i--)
        {
            while(!x.isEmpty() && h[x.peek()] >= h[i])
                x.pop();
            
           if(x.isEmpty())
           {
               right[i] = n;
           }
            else
                right[i] = x.peek();
            x.add(i);
        }
        
        x.clear();
        for(int i = 0; i<n; i++)
        {
            while(!x.isEmpty() && h[x.peek()] >= h[i])
                x.pop();
            
           if(x.isEmpty())
           {
               left[i] = -1;
           }
            else
                left[i] = x.peek();
            x.add(i);
        }
      int max = 0;
        for(int i =0; i<n;i++)
        {
            //System.out.print((right[i])
            int u = (right[i]-left[i]-1)*h[i];
            max = Math.max(max,u);
        }
        return max;
    }
}