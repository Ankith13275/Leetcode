class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(int[] ele : dp){
            Arrays.fill(ele, -1);
        }
        int ans = f(n - 1, coins, amount, dp);
        if(ans > 100000000){
            return -1;
        }
        else return ans;
    }
    
    int f(int ind, int[] coins, int amount, int[][] dp){
        if(ind == 0){
            if(amount % coins[ind] == 0) return amount / coins[ind];
            else return (int)(Math.pow(10, 9));
        }
        if(dp[ind][amount] != -1) return dp[ind][amount];
        int notake = 0 + f(ind - 1, coins, amount, dp);
        int take = Integer.MAX_VALUE;
        if(coins[ind] <= amount){
            take = 1 + f(ind, coins, amount - coins[ind], dp);
        }
        return dp[ind][amount] = Math.min(take, notake);
    }
}