class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        for(int [] x : matrix)
        {
            
            if(x[0]>target)return false;
            // for(int y : x)
            // {
            //     System.out.print(y + " ");
            // }
            // System.out.println();
          if(Arrays.binarySearch(x,target) >= 0) return true; 
               
               // System.out.println(Arrays.binarySearch(x,target) + " ");
            
        }
        return false;
    }
}