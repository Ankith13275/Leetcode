class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            int pick = (i>1) ? dp[i-2] + nums[i] : nums[i];
            int nopick = dp[i - 1];
            dp[i] = Math.max(pick, nopick);
        }
        return dp[nums.length - 1];
    } 
}