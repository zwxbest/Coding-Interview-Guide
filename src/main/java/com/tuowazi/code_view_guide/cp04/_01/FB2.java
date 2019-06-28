package com.tuowazi.code_view_guide.cp04._01;

/**
 * @author zhangweixiao - 2019/6/28
 */
public class FB2 {

    public int fb(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int res = 1;
        int pre = 1;
        int tmp = 0;
        for (int i = 3; i <= n; i++) {
            tmp = res;
            res = res + pre;
            pre = tmp;
        }
        return res;
    }
}
