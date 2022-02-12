class Solution {
    public int ladderLength(String beg, String end, List<String> w)     {
            HashSet<String> x = new HashSet<>();
        boolean is = false;
        for(String g : w)
        {
            if(g.equals(end))
                is = true;
            
            x.add(g);
        }
        if(!is)return 0;
        Queue<String> h = new LinkedList<>();
        h.add(beg);
        int l = 1;
        while(!h.isEmpty())
        {
            l++;
            int n = h.size();
            for(int i = 0; i<n; i++)
            {
                String s = h.poll();
                for(int j = 0; j<s.length(); j++)
                {
                    String tem1 = s.substring(0,j);
                    String tem2 = s.substring(j+1,s.length());
                    String ah = "abcdefghijklmnopqrstuvwxyz";
                    for(int la =0; la<26; la++)
                    {
                        if(x.contains(tem1+ah.substring(la,la+1)+tem2))
                        {
                            String kk = tem1+ah.substring(la,la+1)+tem2;
                            x.remove(kk);
                            if(kk.equals(end))return l;
                            h.add(kk);
                        }
                    }
                }
            }
            // l++;
        }
        return 0;
    }
}