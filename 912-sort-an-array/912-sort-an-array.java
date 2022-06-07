class Solution {
    public int[] sortArray(int[] nums) {
        mergesort(nums, 0, nums.length);
        return nums;
    }
    
    void mergesort(int[] arr, int s, int e){
        if(e - s == 1){
            return;
        }
        
        int m = (s + e) / 2;
        
        mergesort(arr, s, m);
        mergesort(arr, m, e);
        
        merge(arr, s, m, e);
    }
    
    void merge(int[] arr, int s, int m, int e){
        
        int[] mix = new int[e - s];
        
        int i = s;
        int j = m;
        int k = 0;
        
        while(i < m && j < e){
            if(arr[i] > arr[j]){
                mix[k] = arr[j];
                j++;
            }
            else{
                mix[k] = arr[i];
                i++;
            }
            k++;
        }
        
        while(i < m){
            mix[k] = arr[i];
            i++;
            k++;
        }
        
        while(j < e){
            mix[k] = arr[j];
            j++;
            k++;
        }
        
        for(int l = 0; l < mix.length; l++){
            arr[s + l] = mix[l];
        }
        
    } 
}