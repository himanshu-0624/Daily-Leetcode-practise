class Solution {
    int [] powV ;
    public String subStrHash(String s, int po, int m, int k, int hash) {
        char [] x = s.toCharArray();
        int n = x.length;
        long ans[] = new long[n-k+1];
        long pow = 1;
        int j = 0;
        while(j<k)
        {
            pow = ((pow)*(po%m))%m;
            // pow = pow*po;
            j++;
        }
        
        // System.out.println(pow);
        
        long gov = 1;
        int l = ans.length-1;
        
        for( j = n-k; j<n; j++)
        {
            int y = (x[j] - 'a') + 1;
            
            ans[l] = (ans[l] + ((y*gov)%m))%m;
            
            gov = (gov*po)%m;
        }
        
         l--;
       
        
        for(int i = n-1; i>=k; i--)
        {
            ans[l] = (ans[l+1]*po)%m;
            int y = (x[i] - 'a') + 1;
             int xx = (x[i-k] - 'a') + 1;
            ans[l] = ans[l] - ((pow*y)%m);
            
            
            ans[l] = (ans[l]+xx)%m;
              ans[l] = (ans[l]+m)%m;
            l--;
        }
        
        for(int h = 0; h<ans.length; h++)
        {
            // System.out.print(ans[h]+" ");
            if(ans[h] == hash)
                return s.substring(h,h+k);
        }
        return "";
    }
    
  
    
   
}