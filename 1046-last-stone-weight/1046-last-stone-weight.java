class Solution {
    public int lastStoneWeight(int[] s) {
        PriorityQueue<Integer> p = new PriorityQueue<Integer>((a,b)->{
            return b-a;
        });
        
        for(int i =0; i<s.length; i++)
        {
            p.add(s[i]);
        }
        while(p.size()>1)
        {
            int a = p.poll();
            int b = p.poll();
            int c = Math.abs(a-b);
            if(c != 0)
            {
                p.add(c);
            }
        }
        if(p.size() == 0)return 0;
        return p.peek();
    }
}