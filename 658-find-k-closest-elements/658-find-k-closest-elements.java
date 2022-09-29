class Solution {
    public List<Integer> findClosestElements(int[] arr1, int k, int x) {
        List<Integer> arr = new ArrayList<>();
        for(int i : arr1)
        {
            arr.add(i);
        }
        Collections.sort(arr,(a,b)->{
           int val = Integer.compare(Math.abs(a-x),Math.abs(b-x));
            if(val == 0)
            return Integer.compare(a,b);
            return val;
        });
        
        List<Integer> ans = new ArrayList<Integer>();
        for(int i = 0; i<k && i<arr1.length; i++)
            ans.add(arr.get(i));
        Collections.sort(ans);
        return ans;
    }
}