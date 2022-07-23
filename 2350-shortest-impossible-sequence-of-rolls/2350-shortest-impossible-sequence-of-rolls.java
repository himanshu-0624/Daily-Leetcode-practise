class Solution
{
    public int shortestSequence(int[] ro, int k) 
    {
         int [] ans = new int[k+1];
        int cnt = 0;
        int l = 0;
         for(int i : ro)
         {
             ans[i]++;
             if(ans[i] == 1)
                 cnt++;
              // System.out.println(cnt);
             if(cnt == k)
             {
                 // System.out.println(cnt);
                 cnt = 0;
                 l++;
                 ans = new int[k+1];
             }
         }
        
        return l + 1;
    }
}