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
       boolean[] prev = new boolean[k + 1];
       prev[0] = true;
        
        if(arr[0]<=k) prev[arr[0]] = true;
        
        for(int ind = 1; ind<n; ind++){
            boolean[] curr = new boolean[k + 1];
            curr[0] = true;
            for(int target= 1; target<=k; target++){
                boolean notTaken = prev[target];
                boolean taken = false;
                if(arr[ind]<=target) taken = prev[target-arr[ind]];
                curr[target]= notTaken||taken;
            }
            prev = curr;
        }
       return prev[k];
   }
}