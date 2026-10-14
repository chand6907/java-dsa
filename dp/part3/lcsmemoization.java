package dp.part3;

public class lcsmemoization {
    private static int[][] dp;

    public static int lcs(String s1, String s2, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if (dp[n][m] != -1) {
            return dp[n][m];
        }
        
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            dp[n][m] = 1 + lcs(s1, s2, n - 1, m - 1);
        } else {
            dp[n][m] = Math.max(lcs(s1, s2, n - 1, m), lcs(s1, s2, n, m - 1));
        }

        return dp[n][m];
    }

    public static void main(String args[]) {    
        String s1 = "abcde";
        String s2 = "ace";
        int n = s1.length();
        int m = s2.length();

        // 1. Allocate space
        dp = new int[n + 1][m + 1];

        // 2. Initialize every cell to -1 using nested for loops
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(lcs(s1, s2, n, m)); // Output: 3
    }
}