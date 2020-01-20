class Solution {
    public double myPow(double x, int n) {
        if (x == 1){
            return x;
        } else if(n < 0){
            n = n * -1;
            return 1 / tailRecursion(x, n);
        } else {
            return tailRecursion(x, n);
        }
    }
    
    double tailRecursion(double x, int n){
        if(n==0){
            return 1;
        }
        
        double m = tailRecursion(x, n/2);
        if(n%2 == 0){
            return m * m;
        }
        return x * m * m;
    }
}
