class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped)     {
        int n = pushed.length;
        int m = popped.length;
        
        int i = 0;
        int j = 0;
        Stack<Integer> x = new Stack<>();
        
        while(i<n || j<m)
        {
            if(i<n)
            {
                x.add(pushed[i]);
                i++;
            }
            
            while(j<m && !x.isEmpty() && x.peek() == popped[j])
            {
                j++;
                x.pop();
            }
           
            if(i == n && !x.isEmpty())
                return false;
           
        }
        
        return x.isEmpty();
        
    }
}