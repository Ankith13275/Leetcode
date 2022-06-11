class Solution {
    
    List<List<Integer>> output = new ArrayList();
    
    void helper(int[] nums, ArrayList<Integer> curr, int i){
        
        if(i == nums.length){
            output.add(new ArrayList<>(curr));
            return;
        }
        
        curr.add(nums[i]);
        helper(nums, curr, i + 1);
        curr.remove(curr.size() - 1);
        helper(nums, curr, i + 1);
        return;
        
    }
    

    public List<List<Integer>> subsets(int[] nums) {
        
        ArrayList<Integer> curr = new ArrayList<>();
        helper(nums, curr, 0);
        return output;
    }
}