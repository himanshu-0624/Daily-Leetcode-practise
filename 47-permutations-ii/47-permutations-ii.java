class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>();
        HashMap<Integer,Integer> x = new HashMap<>();
        for(int i : nums)
        {
            x.put(i,x.getOrDefault(i,0)+1);
        }
        
        
        call(x,new ArrayList<Integer>(),nums.length);
        return ans;
        
    }
    
    void call(HashMap<Integer,Integer> map,ArrayList<Integer> x ,        int n)
    {
        if(x.size() == n)
        {
            List<Integer> d = new ArrayList<>();
            for(int i: x)
            {
                d.add(i);
            }
            
            ans.add(d);
            return;
        }
        
        for(int i : map.keySet())
        {
            int val = map.get(i);
            if(val == 0)
                continue;
            x.add(i);
            map.put(i,val-1);
            call(map,x,n);
            
           x.remove(x.size()-1);
            map.put(i,val);
        }
        
        
    }
    
 
}