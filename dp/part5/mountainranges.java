public class mountainranges {
    
    public static int countMountainRanges(int n) {
        // The number of mountain ranges with n upstrokes and n downstrokes is given by the nth Catalan number
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



    public static void main(String[] args) {
        int n = 3; // Change this value to compute mountain ranges for different n
        System.out.println(countMountainRanges(n));
    }
}
