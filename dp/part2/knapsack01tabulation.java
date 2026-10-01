package dp.part2;

public class knapsack01tabulation {


    public static void print(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    // Time Complexity : O(n*w)
    public static int knapsackTabulation(int val[], int wt[], int W) {
        int n = val.length;

        int dp[][] = new int[n + 1][W + 1];

        // Base cases
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {

                int v = val[i - 1];
                int w = wt[i - 1];

                if (w <= j) {

                    // Include current item
                    int incprofit = v + dp[i - 1][j - w];

                    // Exclude current item
                    int excprofit = dp[i - 1][j];

                    dp[i][j] = Math.max(incprofit, excprofit);

                } else {

                    // Cannot include current item
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        print(dp);
        return dp[n][W];
    }

    public static void main(String args[]) {

        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7;

        System.out.println(knapsackTabulation(val, wt, W));
    }
}