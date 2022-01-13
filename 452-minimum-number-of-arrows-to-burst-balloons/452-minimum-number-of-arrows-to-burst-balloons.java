class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        Arrays.sort(points,(a,b)->{
           int sign = Integer.compare(a[1],b[1]);
            if(sign == 0)
                return Integer.compare(a[0],b[0]);
            return sign;
        });
        
        Stack<int []> x = new Stack<>();
        x.add(points[0]);
        
        for(int [] d : points)
        {
            int [] arr = x.peek();
            // System.out.println(arr[1]+" "+d[0]);
            if(arr[1] < d[0])
            {
                x.add(d);
            }
           
        }
        return x.size();
    }
}