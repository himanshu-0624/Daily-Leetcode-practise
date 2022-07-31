class NumArray {
     int [] arr;
     int n;
    public NumArray(int[] nums) {
         n = nums.length;
        arr = new int[4*n];
        build(arr,nums,1,0,n-1);
    }
    
    void build(int [] arr, int [] nums, int v, int i, int j)
    {
        if(i == j)
        {
            arr[v] = nums[i];
            
        }
        else
        {
            int mid = i + (j-i)/2;
            build(arr,nums,2*v,i,mid);
            build(arr,nums,2*v+1,mid+1,j);
            arr[v] = arr[2*v] + arr[2*v+1];
        }
    }
    
    void update( int val, int in, int v, int i, int j)
    {
        if(i == j )
        {
            arr[v] = val;
            
        }
        else
        {
            int mid = i + (j-i)/2;
            if(in <= mid)
            update(val,in,2*v,i,mid);
            else
            update(val,in,2*v+1,mid+1,j);
            arr[v] = arr[2*v] + arr[2*v+1];
        }
    }
    
    int call(int v, int l, int r, int i, int j)
    {
        if(r < i || j < l)
            return 0;
        if(l == i && r == j)
            return arr[v];
        int mid = l + (r-l)/2;
        
        int ans = call(2*v,l,mid,i,Math.min(mid,j));
        ans+=call(2*v+1,mid+1,r,Math.max(mid+1,i),j);
        
        return ans;
    }
    
    public void update(int index, int val) {
        update(val,index,1,0,n-1);
    }
    
    public int sumRange(int l, int r) {
        return call(1,0,n-1,l,r);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */