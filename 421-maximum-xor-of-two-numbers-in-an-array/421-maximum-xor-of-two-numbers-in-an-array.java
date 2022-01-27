class Solution {
    class Node {
        Node [] x;
       public Node()
       {
           x = new Node[2];
       }
        
        Node get(int pos)
        {
            return x[pos];
        }
        boolean contains(int i)
        {
            return x[i] != null;
        }
        void put(int pos, Node n)
        {
            x[pos] = n;
             
        }
    }
    
    
    public int findMaximumXOR(int[] nums) {
        Node root = new Node();
        for(int num : nums)
        {
            Node cur = root;
            for(int i = 31; i>=0; i--)
            {
                if(((num>>i)&1) == 0)
                {
                    if(cur.contains(0))
                    {
                        cur = cur.get(0);
                    }
                    else
                    {
                        Node p = new Node();
                        cur.put(0,p);
                        cur = p;
                    }
                }
                else
                {
                    if(cur.contains(1))
                    {
                        cur = cur.get(1);
                    }
                    else
                    {
                        Node p = new Node();
                        cur.put(1,p);
                        cur = p;
                    }
                }
            }
        }
        int max = 0;
        for(int num : nums)
        {
            Node cur = root;
            int ans = 0;
            for(int i = 31; i>=0; i--)
            {
                if(((num>>i)&1) == 0)
                {
                    if(cur.contains(1))
                    {
                        ans+= (1<<i);
                        cur = cur.get(1);
                    }
                    else
                    {
                        cur = cur.get(0);
                    }
                }
                else
                {
                   if(cur.contains(0))
                    {
                        ans+= (1<<i);
                        cur = cur.get(0);
                    }
                    else
                    {
                        cur = cur.get(1);
                    } 
                }
            }
            max = Math.max(max,ans);
        }
        return max;
        
    }
}