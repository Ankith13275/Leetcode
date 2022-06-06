class Solution {
    public int triangularSum(int[] nums) {
        return sum(nums, nums.length);
    }
    
    public int sum(int[] nums, int n){
        
        if(n == 1){
            return nums[0];
        }
        
        int count = 0;
        
        for(int i = 0; i < n - 1; i++){
            count = (nums[i] + nums[i + 1]) % 10;
            nums[i] = count;
        }
        
        return sum(nums, n - 1);
    }
}