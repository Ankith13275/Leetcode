class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int first = cost[0];
        int second = cost[1];
        
        int curr = 0;
        
        for(int i = 2; i <= n; i++){
            if(i == n){
                curr = Math.min(first, second);
            }
            else{
                curr = cost[i] + Math.min(first, second);
            }
            
            first = second;
            second = curr;
        }
        
        return second;
    }
}