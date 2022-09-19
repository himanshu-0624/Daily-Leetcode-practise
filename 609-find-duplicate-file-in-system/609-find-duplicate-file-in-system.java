class Solution {
    public List<List<String>> findDuplicate(String[] paths)
    {
       List<List<String>> ans = new ArrayList<>();
       HashMap<String,ArrayList<String>> x = new HashMap<>();
       
        for(String h : paths)
        {
            String [] val = h.split(" ");
            // String [] g = val[1].split(" ");
            for(int k = 1; k<val.length; k++)
            {  
                String l = val[k];
                int i = 0;
            while(i<l.length() && l.charAt(i) != '(')
                i++;
            String ha = l.substring(i,l.length());
            if(!x.containsKey(ha))
            {
               x.put(ha,new ArrayList<String>());
                
            }
             x.get(ha).add(val[0]+"/"+l.substring(0,i)); 
            }
            
            
        }
         
        for(String key : x.keySet())
        {
            ArrayList<String> g = x.get(key);
            if(g.size() > 1 )
                ans.add(g);
        }
        
        return ans;
    }
}