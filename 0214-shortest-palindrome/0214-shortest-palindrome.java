class Solution {
    public String shortestPalindrome(String s) { 
        
        StringBuilder stringBuilder = new StringBuilder(s);
        StringBuilder reverseStringBuilder = new StringBuilder(s).reverse();        
        stringBuilder.append("#").append(reverseStringBuilder);
        int[] lps = computeLPS(stringBuilder.toString());

        return new StringBuilder(s.substring(lps[lps.length - 1])).reverse().toString() + s;
    }
    
    private static int[] computeLPS(String t) {
        
        int tLength = t.length(), i = 1, preLengthLPS = 0;
        int[] lps = new int[tLength];
        lps[0] = 0; 
        while (i < tLength) {
            if (t.charAt(i) == t.charAt(preLengthLPS)) {
                preLengthLPS++;
                lps[i] = preLengthLPS;
                i++;
            } else {
                if (preLengthLPS != 0)
                    preLengthLPS = lps[preLengthLPS - 1];
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        return lps;
    }
}