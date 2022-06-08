class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        int[] ngr = nextGreaterRight(nums2);
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i = 0; i < nums2.length; i++){
            hm.put(nums2[i], ngr[i]);
        }
        
        int[] nge = new int[nums1.length];
        
        for(int i = 0; i < nge.length; i++){
            nge[i] = hm.get(nums1[i]);
        }
        
        return nge;
    }
    
   public int[] nextGreaterRight(int[] arr){

        Stack<Integer> st = new Stack<>();

        int[] ngr = new int[arr.length];

        st.push(arr[arr.length - 1]);

        ngr[arr.length - 1] = -1;

        for(int i = arr.length - 2; i >= 0; i--){

            while(!st.isEmpty() && arr[i] >= st.peek()){
                st.pop();
            }

            if(st.isEmpty()){
                ngr[i] = -1;
            }else{
                ngr[i] = st.peek();
            }

            st.push(arr[i]);

        }

        return ngr;
    }
}