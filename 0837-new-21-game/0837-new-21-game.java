class Solution {
    public double new21Game(int N, int K, int W) {
        if (K == 0 || N >= K + W) return 1.0;
        double res = 0.0, Wsum = 1.0;
        double[] dp = new double[N + 1];
        dp[0] = 1.0;
        for (int i = 1; i <= N; ++i) {
            dp[i] = Wsum / W;
            if (i < K) Wsum += dp[i];
            else res += dp[i];
            if (i - W >= 0) Wsum -= dp[i - W];
        }
        return res;
    }
}