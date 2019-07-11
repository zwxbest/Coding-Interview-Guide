package com.tuowazi.code_view_guide.cp05._13;

/**
 * @author zhangweixiao - 2019/7/9
 */
public class GetPara {

    public int[][] getDP(char[] str) {
        int[][] dp = new int[str.length][str.length];
        for (int j = 0; j < str.length; j++) {
            //两个字符的情况
            dp[j - 1][j] = str[j - 1] == str[j] ? 0 : 1;
            for (int i = j - 2; i >= 0; i--) {
                if (str[i] == str[j]) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp;
    }
}
