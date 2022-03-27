class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Pair> x = new PriorityQueue<>((a,b)->{
            int y = -1*Integer.compare(a.x,b.x);
            int z =  -1*Integer.compare(a.y,b.y);
            if(y ==0)
                return z;
            return y;
        });
        int i = 0;
        for(int [] m : mat)
        {
            int cnt = 0;
            for(int j : m)
            {
                cnt+=j;
            }
            Pair f = new Pair(cnt,i);
            if(x.size() <k)
            {
                x.add(f);
            }
            else if(x.peek().x > cnt)
            {
                x.poll();
                x.add(f);
            }
           
            i++;
        }
        
        int ans[] = new int[k];
        i = 0;
        while(x.size() != 0)
        {
            ans[i] = x.poll().y;
            
            i++;
        }
        i = 0;
        int j = k-1;
        while(i<j)
        {
            int t = ans[i];
            ans[i] = ans[j];
            ans[j]  = t;
            i++;
            j--;
        }
        
        return ans;
        
    }
    
    class Pair
    {
        int x;
        int y;
        
        public Pair(int x, int y)
        {
            this.x =x;
            this.y = y;
        }
    }
}