class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        ArrayList<Integer> y = new ArrayList<>();
         ArrayList<Integer> z = new ArrayList<>();
        for(int [] r : grid)
        {
            for(int  p : r)
            {
                y.add(p);
            }
        }
        k = k%(grid.length*grid[0].length);
         for(int i = y.size()-k; i<y.size(); i++)
        {
              z.add(y.get(i));
        }
        for(int i = 0; i<y.size()-k; i++)
        {
           z.add(y.get(i)); 
        }
       
        
        
        List<List<Integer>> u = new ArrayList<>();
              int n = grid.length;
              int a = grid[0].length;
        int cnt = 0;
        for(int i = 0; i<n; i++)
        {
            List<Integer> ua = new ArrayList<>();
            for(int j=0; j<a; j++)
            {
                ua.add(z.get(cnt));
                cnt++;
            }
            u.add(ua);
        }
        return u;
        
    }
}