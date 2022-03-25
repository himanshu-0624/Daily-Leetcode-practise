class Solution {
    public int twoCitySchedCost(int[][] costs) {
       Arrays.sort(costs,(a,b)->{
            return Math.abs(b[0]-b[1])-Math.abs(a[0]-a[1]);
        });
int aCity = 0;
		int bCity = 0;
		int n = costs.length/2;
		int ans = 0;
		for(int [] ele : costs){
			if(aCity == n)ans+=ele[1];
			else if(bCity == n)ans +=ele[0];
			else {
				if(ele[0]<=ele[1]){
					ans += ele[0];
					aCity++;
				}else {
					ans += ele[1];
					bCity++;
				}
			}
		}
		return ans;
    }
        
    }
