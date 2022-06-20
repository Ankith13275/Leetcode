class Solution {
  int[] lanes = new int[]{1,2,3};
  public int minSideJumps(int[] obstacles) {
    int n = obstacles.length;
    Integer[][] dp = new Integer[n][4];
    return jump(n, obstacles, dp, 2, 0);
  }
  
  public int jump(int n, int[] obstacles, Integer[][] dp, int currLane, int idx) {
    if(idx >= n-1) return 0;
    if(dp[idx][currLane] != null) return dp[idx][currLane];
    int rockLocation = obstacles[idx+1];
    int min = n; 
    
    if(currLane == rockLocation) {
      for(int lane: lanes) {
        if(lane == currLane) continue;
        if(obstacles[idx] == lane) continue;
        int res = jump(n, obstacles, dp, lane, idx);    
        min = Math.min(min, res);
      }
      dp[idx][currLane] = 1+min;
      return 1 + min;
    }
    min = jump(n, obstacles, dp, currLane, idx+1);
    dp[idx][currLane] = min;
    return min;
  }
}