class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalsum = 0;
        for(int i = 0; i < n; i++){
            totalsum += nums[i];
        }
        if(totalsum % 2 == 1) return false;
        int sum = totalsum / 2;
        return f(n, nums, sum);
    }
    
   boolean f(int n, int arr[], int k){
        boolean dp[][]= new boolean[n][k+1];
        
        for(int i=0; i<n; i++){
            dp[i][0] = true;
            
        }
        
        if(arr[0]<=k) dp[0][arr[0]] = true;
        
        for(int ind = 1; ind<n; ind++){
            for(int target= 1; target<=k; target++){
                boolean notTaken = dp[ind-1][target];
                boolean taken = false;
                if(arr[ind]<=target) taken = dp[ind-1][target-arr[ind]];
                dp[ind][target]= notTaken||taken;
                
            }
            
        }
       return dp[n-1][k];
   }
}