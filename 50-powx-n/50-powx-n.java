class Solution {
    public double myPow(double x, int n) {
        
        if(n == 0){
            return 1;
        }
        
        if(n > 0){
            if(n % 2 != 0){
                return myPow(x * x, (n -1) / 2) * x;
            }
            else{
                return myPow(x * x, n / 2);
            }
        }
        
        else{
            if(n % 2 != 0){
                return myPow(x * x, (n + 1) / 2) * (1 / x);
            }
            else{
                return myPow(x * x, n / 2);
            }
        } 
    }
}