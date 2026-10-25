public class countbst {
    
    public static int countbst(int n) {
        // The number of unique BSTs with n nodes is given by the nth Catalan number
        int dp[] = new int[n + 1];
        dp[0] = 1; // Base case: C(0) = 1
        dp[1] = 1; // Base case: C(1) = 1

        for (int i = 2; i <= n; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
    }
    public static void main (String args[]){
        int n = 4;
        
        System.out.println(countbst(n)); // Outputs 14
    }
}
