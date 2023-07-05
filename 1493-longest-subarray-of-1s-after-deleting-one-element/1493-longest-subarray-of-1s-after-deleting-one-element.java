public class Solution {
    public int longestSubarray(int[] nums) {
        int maxLength = 0;
        int left = 0;
        int right = 0;
        int countZeros = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                countZeros++;
            }

            while (countZeros > 1) {
                if (nums[left] == 0) {
                    countZeros--;
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left);

            right++;
        }

        return maxLength;
    }
}
