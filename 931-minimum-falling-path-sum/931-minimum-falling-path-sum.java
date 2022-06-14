class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        
        for(int i = 0; i < n; i++){
            dp[0][i] = matrix[0][i];
        }
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < n; j++){
                
                int up = matrix[i][j] + dp[i - 1][j];
                
                int ld = matrix[i][j];
                if (j - 1 >= 0) ld += dp[i - 1][j - 1];
                else ld += (int)Math.pow(10,9);
                
                int rd = matrix[i][j];
                if(j + 1 < n) rd += dp[i - 1][j + 1];
                else rd +=(int)Math.pow(10,9);
                
                dp[i][j] = Math.min(up, Math.min(ld, rd));
            }
        }
        
        int min = (int)Math.pow(10,9);
        for(int i = 0; i < n; i++){
            min = Math.min(min, dp[n - 1][i]);
        }
        return min;
    }
}