class Solution {
    public int maxVowels(String s, int k) {
    int maxVowels = 0;
    int windowVowels = 0;
    // Count the vowels in the first window of length k
    for (int i = 0; i < k; i++) {
        if (isVowel(s.charAt(i))) {
            windowVowels++;
        }
    }
    maxVowels = windowVowels;
    // Slide the window and count the vowels in each new window
    for (int i = k; i < s.length(); i++) {
        if (isVowel(s.charAt(i))) {
            windowVowels++;
        }
        if (isVowel(s.charAt(i - k))) {
            windowVowels--;
        }
        // Update the maximum number of vowels found so far
        maxVowels = Math.max(maxVowels, windowVowels);
    }
    return maxVowels;
}

private boolean isVowel(char c) {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
}

}