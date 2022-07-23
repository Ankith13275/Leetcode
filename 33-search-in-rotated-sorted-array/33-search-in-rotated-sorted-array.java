class Solution {
    public int search(int[] nums, int target) {
        int pivot = pivot(nums);
        if(pivot == -1){
            return bs(nums, target, 0, nums.length - 1);
        }
        if(nums[pivot] == target){
            return pivot;
        }
        if(bs(nums, target, 0,  pivot - 1) == -1){
            return bs(nums, target, pivot + 1, nums.length - 1);
        }
        else{
            return bs(nums, target, 0,  pivot - 1);
        }
    }
    
    public int pivot(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(mid < end && arr[mid] > arr[mid + 1]){
                return mid;
            }
            else if(mid > start && arr[mid] < arr[mid - 1]){
                return mid - 1;
            }
            else if(arr[start] >= arr[mid]){
                end = mid - 1;
            }
            else{
                start = mid + 1; 
            }
        }
        return -1;
    }
    
    public int bs(int[] arr, int target, int start, int end){
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] > target){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return -1;
    }
    
}