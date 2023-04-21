class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int mod = (int)1e9 + 7;
        int[][] dp = new int[n+1][minProfit+1];
        dp[0][0] = 1;
        for (int k = 0; k < group.length; k++) {
            int g = group[k], p = profit[k];
            for (int i = n; i >= g; i--) {
                for (int j = minProfit; j >= 0; j--) {
                    int prevProfit = Math.max(0, j - p);
                    dp[i][j] = (dp[i][j] + dp[i-g][prevProfit]) % mod;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            ans = (ans + dp[i][minProfit]) % mod;
        }
        return ans;
    }
}
