import java.util.HashMap;
import java.util.Map;

class Solution {
    private int f(int[] piles, int p, int i, int m, Map<String, Integer> memo) {
        if (i == piles.length) {
            return 0;
        }

        String key = p + "_" + i + "_" + m;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int res = p == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        int s = 0;
        for (int x = 1; x <= Math.min(2 * m, piles.length - i); x++) {
            s += piles[i + x - 1];
            if (p == 0) {
                res = Math.max(res, s + f(piles, 1, i + x, Math.max(m, x), memo));
            } else {
                res = Math.min(res, f(piles, 0, i + x, Math.max(m, x), memo));
            }
        }

        memo.put(key, res);
        return res;
    }

    public int stoneGameII(int[] piles) {
        Map<String, Integer> memo = new HashMap<>();
        return f(piles, 0, 0, 1, memo);
    }
}
