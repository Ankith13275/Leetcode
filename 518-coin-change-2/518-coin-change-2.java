class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(int[] ele : dp){
            Arrays.fill(ele, -1);
        }
        return f(n - 1, coins, amount, dp);
    }
    
    int f(int ind, int[] coins, int amount, int[][] dp){
        if(ind == 0){
            if(amount % coins[ind] == 0) return 1;
            else return 0;
        }
        if(dp[ind][amount] != -1) return dp[ind][amount];
        int notake = f(ind - 1, coins, amount, dp);
        int take = 0;
        if(coins[ind] <= amount){
            take = f(ind, coins, amount - coins[ind], dp);
        }
        return dp[ind][amount] = take + notake;
    }
}