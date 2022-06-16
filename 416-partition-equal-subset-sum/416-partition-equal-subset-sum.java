class Solution {
    public boolean canPartition(int[] nums) {
        int N = nums.length;
        int totalsum = 0;
        for(int i = 0; i < N; i++){
            totalsum += nums[i];
        }
        if(totalsum % 2 == 1) return false;
        int sum = totalsum / 2;
        int[][] dp = new int[N][sum + 1];
        for(int[] ele : dp){
            Arrays.fill(ele, -1);
        }
        return f(N - 1, nums, sum, dp);
    }
    
    boolean f(int N, int arr[], int sum, int[][] dp){
        if(sum == 0) return true;
        if(N == 0) return arr[0] == sum;
        if(dp[N][sum] != -1){
            if(dp[N][sum] == 1) return true;
            else if(dp[N][sum] == 0)return false;
        }
        
        boolean take = false;
        if(sum >= arr[N]){
            take = f(N - 1, arr, sum - arr[N], dp);
        }
        boolean Notake = f(N - 1, arr, sum, dp);
        
        boolean ans = take || Notake;
        
        if(ans) dp[N][sum] = 1;
        else dp[N][sum] = 0;
        
        return ans;
    }
}