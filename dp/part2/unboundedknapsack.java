package dp.part2;

public class unboundedknapsack {

    static int unboundedKnapsack(int[] wt, int[] val, int W) {

        int n = wt.length;

        // dp[i][j] = maximum value using first i items
        // with capacity j
        int[][] dp = new int[n + 1][W + 1];

        // Fill the DP table
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= W; j++) {

                // Current item can be included
                if (wt[i - 1] <= j) {

                    // Include current item again
                    int include = val[i - 1] + dp[i][j - wt[i - 1]];

                    // Don't include current item
                    int exclude = dp[i - 1][j];

                    dp[i][j] = Math.max(include, exclude);

                } else {

                    // Cannot include current item
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][W];
    }

    public static void main(String[] args) {

        int[] wt = {2, 3, 4, 5};
        int[] val = {3, 4, 5, 6};

        int W = 8;

        int result = unboundedKnapsack(wt, val, W);

        System.out.println("Maximum Value = " + result);
    }
}