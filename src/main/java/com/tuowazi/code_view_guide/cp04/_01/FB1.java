package com.tuowazi.code_view_guide.cp04._01;

/**
 * @author zhangweixiao - 2019/6/28
 */
public class FB1 {

    public int fb(int n){
        if(n < 1){
            return 0;
        }
        if(n == 1 || n == 2){
            return 1;
        }
        return fb(n-1)+fb(n-2);
    }
}
