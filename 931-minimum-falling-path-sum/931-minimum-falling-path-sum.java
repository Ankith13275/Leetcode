class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        int min = (int)Math.pow(10,9);
        for(int i = 0; i < n; i++){
            min = Math.min(min, min(matrix, n - 1, i, dp));
        }
        return min;
    }
    
    int min(int[][] matrix, int i, int j, int[][] dp){
        int n = matrix.length;
        if(j < 0 || j >= n) return (int)Math.pow(10,9);
        if(i == 0) return matrix[0][j];
        if(dp[i][j] != 0) return dp[i][j];
        int up = matrix[i][j] + min(matrix, i - 1, j, dp);
        int ld = matrix[i][j] + min(matrix, i - 1, j - 1, dp);
        int rd = matrix[i][j] + min(matrix, i - 1, j + 1, dp);
        return dp[i][j] = Math.min(up, Math.min(ld, rd));
    }
}