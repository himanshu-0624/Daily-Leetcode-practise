class Solution {
    public List<Integer> findSubstring(String s, String[] words)
    {
        List<Integer> ans = new ArrayList<>();
        int l = words[0].length();
        int n = words.length;
        long p = call(l-1);
        
        HashMap<Long,Integer> map = new HashMap<Long,Integer>();
        for(String w : words)
        {
            // System.out.println(w);
            long val = compute_hash(w.toCharArray());
            // System.out.print(val+" ");
            map.put(val,map.getOrDefault(val,0)+1);
        }
         // System.out.println();
        ArrayList<Long> x = new ArrayList<>();
        if(l*words.length > s.length())
            return ans;
        for(int i = 0; i<l*words.length; i=i+l)
        {
             // System.out.println(s.substring(i,i+l+1));
            x.add(compute_hash(s.substring(i,i+l).toCharArray()));
        }
        // print(x);
        
        int i = 0;
        while(true)
        {
            boolean h  = true;
            HashMap<Long,Integer> y = new HashMap<Long,Integer>(map);
            for(long e : x )
            {
                y.put(e,y.getOrDefault(e,0)-1);
                if(y.get(e) == -1)
                {
                    h = false;
                    break;
                }
                else if(y.get(e) == 0)
                    y.remove(e);
            }
            
            
            
            if(h)
            {
                ans.add(i);
            }
            i++;
            // System.out.print(i+" ");
            if(i+l*words.length > s.length())
            {
                // System.out.print(i);
                break;
                
            }
                
            
            int d = i;
            for(int j = 0; j<x.size(); j++)
            {
                char c = s.charAt(d-1);
                char pa = s.charAt(d+l-1);
                // long val = update(x.get(j),c,pa,31,p);
                long val1 = compute_hash(s.substring(d,d+l).toCharArray());
                // System.out.println(s.substring(d,d+l+1));
                x.set(j,val1);
                d+=l;
            }
            
            
        }
        
        return ans;
        
        
    }
   
    long call( long i )
    {
        long p = 31;
        long m = (long)1e9+7;
        if(i == 0)
            return 1;
        
        long ans = p;
        i--;
        while(i>0)
        {
            if(i%2 == 0)
            {
                ans = (ans*ans)%m;
                i/=2;
            }
            else
            {
               ans = (ans*p)%m;  
               i--;   
            }
        }
        return ans;
    }
    
   long update(long val, char a, char b,  long p, long pl)
   {
       // System.out.println(a+" "+b+" "+val);
      
       long m = (long)1e9+ 7;
       val-=((a-'a'+1)*pl);
       val = (val + m)%m;
       val = (val*p)%m;
       val = (val + b-'a'+1)%m;
       return val;
       
   }
    
   long compute_hash(char [] x) 
   {
     long p = 31;
     long m = (long)1e9 + 9;
     long hash_value = 0;
     long p_pow = 1;
     for (int i = x.length-1; i>=0; i--)
     {
         char c = x[i];
         hash_value = (hash_value + (c - 'a' + 1) * p_pow) % m;
         p_pow = (p_pow * p) % m;
     }
     return hash_value;
   }
    
    // void print(ArrayList<Long> a)
    // {
    //     for(long f : a)
    //     {
    //         System.out.print(f+" ");
    //     }
    //     System.out.println();
    // }

}