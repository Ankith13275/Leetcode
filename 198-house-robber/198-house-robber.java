class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int prev = nums[0];
        int prev2 = 0;  
        for(int i = 1; i < nums.length; i++){
            int pick = (i>1) ? prev2 + nums[i] : nums[i];
            int nopick = prev;
            int curr = Math.max(pick, nopick);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    } 
}