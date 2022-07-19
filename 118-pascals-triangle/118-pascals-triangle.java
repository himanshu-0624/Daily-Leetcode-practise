class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> a = new ArrayList<Integer>();
        a.add(1);
        ans.add(a);
        for(int i = 1; i<n; i++)
        {
            List<Integer> arr = new ArrayList<>();
            arr.add(1);
            List<Integer> p = ans.get(i-1);
            for(int j =0; j<p.size()-1; j++)
            {
                arr.add(p.get(j)+p.get(j+1));
            }
            arr.add(1);
            ans.add(arr);
        }
        
        return ans;
    }
}