import java.util.Arrays;

public class catalanmemo {
    
    public static int catlmemo(int n, int dp[]) {
        // Base cases: C(0) = 1, C(1) = 1
        if (n == 0 || n == 1) {
            return 1;
        }

        // Return cached result if already calculated
        if (dp[n] != -1) {
            return dp[n];
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            // Recursively calculate subproblems with memoization
            ans += catlmemo(i, dp) * catlmemo(n - i - 1, dp);
        }

        dp[n] = ans;
        return dp[n];
    }

    public static void main(String args[]) {
        int n = 4;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);

        // Pre-populating base cases in DP table (optional, but good practice)
        dp[0] = 1;
        dp[1] = 1;

        System.out.println(catlmemo(n, dp)); // Outputs 14
    }
}