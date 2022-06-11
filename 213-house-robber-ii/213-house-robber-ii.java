class Solution {
    
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] nums1 = Arrays.copyOfRange(nums, 1, nums.length);
        int[] nums2 = Arrays.copyOfRange(nums, 0, nums.length - 1);
        return Math.max(rob1(nums1), rob1(nums2));
    }
    
    int rob1(int[] nums) {
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

   