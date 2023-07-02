package com.example;

public class MinimalDistance {

    /**
     * Wagner-Fischer algorithm implementation to find Levenshtein distance
     */
    public static int minimalDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            throw new IllegalArgumentException("Both words must now be null");
        }
        int n = word1.length();
        int m = word2.length();

        int[][] dp = calculateDistance(word1, word2);
        return dp[n][m];
    }

    private static int[][] calculateDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];

        dp[0][0] = 0;
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int deletion = dp[i - 1][j] + 1;
                int insertion = dp[i][j - 1] + 1;
                int substitution = dp[i - 1][j - 1] + 1;
                boolean matches = word1.charAt(i - 1) == word2.charAt(j - 1);
                int match = dp[i - 1][j - 1];
                dp[i][j] = Math.min(Math.min(deletion, insertion), matches ? match : substitution);
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        System.out.println(minimalDistance(args[0], args[1]));
    }

}
