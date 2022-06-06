class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        
        int rem = nums.length - k;
        
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < nums.length; i++){
            
            while(!st.isEmpty() && rem > 0 && nums[i] < st.peek()){
                st.pop();
                rem--;
            }
            
            st.push(nums[i]);  
        }
        
        while(rem > 0){
            st.pop();
            rem--;
        }
        
        int[] ans = new int[st.size()];
        
        for(int i = ans.length - 1; i >= 0; i--){
            ans[i] = st.pop();
    }
        return ans;
    }
}