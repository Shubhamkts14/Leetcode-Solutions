class Solution {
    public int longestArithSeqLength(int[] nums) {
        int maxLength = 0;
        int n = nums.length;

        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> diffMap = new HashMap<>();

            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];

                int length = map.getOrDefault(j, diffMap).getOrDefault(diff, 1) + 1;
                maxLength = Math.max(maxLength, length);

                diffMap.put(diff, length);
            }

            map.put(i, diffMap);
        }

        return maxLength;
    }
}