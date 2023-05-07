class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int[] dp = new int[n]; // dp[i] represents the smallest last element of a subsequence of length i+1
        int[] ans = new int[n]; // ans[i] represents the length of the longest obstacle course at i
        
        int len = 0; // len represents the length of the longest subsequence found so far
        
        for (int i = 0; i < n; i++) {
            int lo = 0, hi = len;
            while (lo < hi) { // binary search to find the largest j such that dp[j] <= obstacles[i]
                int mid = lo + (hi - lo) / 2;
                if (dp[mid] <= obstacles[i]) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            
            dp[lo] = obstacles[i]; // update dp[lo] with obstacles[i]
            if (lo == len) { // if we extended the longest subsequence, update len
                len++;
            }
            
            ans[i] = lo + 1; // the length of the longest obstacle course ending at i is lo+1
        }
        
        return ans;
    }
}
