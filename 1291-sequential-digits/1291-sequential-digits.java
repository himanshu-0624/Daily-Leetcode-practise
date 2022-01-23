class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
          List<Integer> x = new ArrayList<>();
        String v = "123456789";
        ArrayList<Integer> y = new ArrayList<>();
        for(int i = 2; i<=v.length(); i++)
        {
            for(int j = 0; j<v.length()-i+1; j++)
            {
                // System.out.print(Integer.parseInt(v.substring(j,j+i))+" ");
                y.add(Integer.parseInt(v.substring(j,j+i)));
            }
        }
         // System.out.println();
        
        for(int i=0;i<y.size();i++)
        {
            int k=y.get(i);
            if(k>=low&&k<=high)
                x.add(k);
              
        }
        
        return x;
          
        
    }
}