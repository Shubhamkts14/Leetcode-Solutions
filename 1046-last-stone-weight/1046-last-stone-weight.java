class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        while (n > 1) {
            Arrays.sort(stones, 0, n);
            int x = stones[n - 2];
            int y = stones[n - 1];
            if (x == y) {
                n -= 2;
            } else {
                stones[n - 2] = y - x; 
                n--; 
            }
        }
        return n == 1 ? stones[0] : 0; 
    }
}
