class Solution {
    public int minSetSize(int[] arr) {
        int [] x = new int[100_001];
        for(int i: arr)
            x[i]++;
        Arrays.sort(x);
        int n = arr.length;
        int ans = 0;
        int cnt  = 0;
        int i = 100000;
        while(cnt < n/2)
        {
            cnt+=x[i];
            i--;
            ans++;
        }
        return ans;
    }
}