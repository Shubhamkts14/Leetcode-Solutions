import java.util.Arrays;

class Solution {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        int[] allCuts = new int[m + 2]; // include 0 and n as the endpoints
        System.arraycopy(cuts, 0, allCuts, 1, m);
        allCuts[m + 1] = n;

        Arrays.sort(allCuts); // sort the cuts

        int[][] dp = new int[m + 2][m + 2]; // dp[i][j] represents the minimum cost between cuts[i] and cuts[j]
        for (int len = 2; len <= m + 1; len++) {
            for (int i = 0; i + len <= m + 1; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + allCuts[j] - allCuts[i]);
                }
            }
        }

        return dp[0][m + 1];
    }
}
