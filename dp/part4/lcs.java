package dp.part4;
//longest common substring
public class lcs {

    // 1. Longest Common Subsequence (LCS)
    // Characters do NOT have to be contiguous
    public static int longestCommonSubsequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    // Carry forward the best result so far
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Result accumulates to the bottom-right corner
        return dp[n][m];
    }

    // 2. Longest Common Substring
    // Characters MUST be contiguous
    public static int longestCommonSubstring(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        int maxLength = 0; // Tracks the highest value found anywhere in the table

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    maxLength = Math.max(maxLength, dp[i][j]);
                } else {
                    // Chain broken: reset to 0
                    dp[i][j] = 0;
                }
            }
        }

        // Result can peak anywhere in the grid
        return maxLength;
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "abfde";

        System.out.println("String 1: " + s1);
        System.out.println("String 2: " + s2);
        System.out.println("----------------------------------------");

        // Subsequence: "abde" (length 4) -> gaps allowed
        int lcsLength = longestCommonSubsequence(s1, s2);
        System.out.println("Longest Common Subsequence length: " + lcsLength);

        // Substring: "ab" or "de" (length 2) -> must be contiguous
        int lcSubstrLength = longestCommonSubstring(s1, s2);
        System.out.println("Longest Common Substring length:   " + lcSubstrLength);
    }
}