class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
       int tot = 0;
        int sur = 0;
        
        int l=0;
        for(int i = 0; i<gas.length; i++)
        {
            tot+=gas[i]-cost[i];
            sur +=gas[i]-cost[i];
            if(sur<0)
            {
                l = i+1;
                sur = 0;
            }
        }
        if(tot<0)return -1;
        return l;
    }
}