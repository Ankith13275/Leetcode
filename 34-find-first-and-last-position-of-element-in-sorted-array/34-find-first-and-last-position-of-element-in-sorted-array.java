class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        ans[0] = bs(nums, target, true);
        if(ans[0] != -1){
            ans[1] = bs(nums, target, false);
        }
        return ans;
    }
    
    public int bs(int[] nums, int target, boolean first){
        int start = 0;
        int end = nums.length - 1;
        int pos = -1;
        
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target > nums[mid]){
                start = mid + 1;
            }
            else if(target < nums[mid]){
                end = mid - 1;
            }
            else{
                pos = mid;
                if(first){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
        }
        return pos;
    }
}