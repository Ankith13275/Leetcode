class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 1;
        int end = arr.length - 1;
        
        while(start < end){
            int m = start + (end - start) / 2;
            if(arr[m] > arr[m - 1] && arr[m] > arr[m + 1]){
                return m;
            }
            else if(arr[m] < arr[m + 1]){
                start = m + 1;
            }
            else if(arr[m] < arr[m - 1]){
                end = m - 1;
            }
        }
        return start;
    }
}