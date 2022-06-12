class Solution {
    
    List<List<Integer>> output = new ArrayList();
    
    public List<List<Integer>> permute(int[] nums) {
        helper(nums, 0);
        return output;
    }
    

    void helper(int[] nums, int i){
        if(i == nums.length){
            List<Integer> ds = new ArrayList<>();
            for(int k : nums){
                ds.add(k);    
            }
            output.add(new ArrayList<>(ds));
            return;
        }

        for(int j = i; j < nums.length; j++){
            swap(nums, i, j);
            helper(nums, i + 1);
            swap(nums, i, j);
        }

        return;

    }

    void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}