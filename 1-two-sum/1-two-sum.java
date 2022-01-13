class Solution {
    public int[] twoSum(int[] nums, int t) {
        
        HashMap<Integer,ArrayList<Integer>> x = new HashMap<>();
        int j  =0 ;
        for(int i : nums)
        {
            if(x.containsKey(i))
            {
                 x.get(i).add(j);
            }
            else
            {
                x.put(i,new ArrayList<Integer>());
                 x.get(i).add(j);
            }
           
            j++;
        }
        j = 0;
         for(int i : nums)
        {  int u = t - i;
            if(x.containsKey(u) && u != i)
            {
               return new int[]{j,x.get(u).get(0)};   
            }
         else if(u == i)
         {
             if(x.get(i).size()>=2)
             {
                 return new int[]{x.get(i).get(0),x.get(i).get(1)};
             }
         }
         j++;
        }
        return new int[]{0,0};
    }
}