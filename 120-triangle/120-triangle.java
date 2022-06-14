class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] temp = new int[n];
        int[] curr = new int[n];
        for(int j = 0; j < n; j++){
            temp[j] = triangle.get(n - 1).get(j);
        }
        for(int i = n - 2; i >= 0; i--){
            for(int j = i; j >= 0; j--){
                int down = triangle.get(i).get(j) + temp[j];
                int diagonal = triangle.get(i).get(j) + temp[j + 1];
                curr[j] = Math.min(down, diagonal);
            }
            temp = curr;
            curr = new int[n];
        }
        return temp[0];
    }
}