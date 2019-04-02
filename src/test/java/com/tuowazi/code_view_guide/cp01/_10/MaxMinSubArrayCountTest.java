package com.tuowazi.code_view_guide.cp01._10;

import base.BaseTest;
import org.junit.Test;

/**
 * @author zhangweixiao - 19-3-22
 */
public class MaxMinSubArrayCountTest extends BaseTest {

    private  MaxMinSubArrayCount maxMinSubArrayCount = new MaxMinSubArrayCount();

    /**
     * 正序
     */
    @Test
    public void test(){
        int subArrayCount = maxMinSubArrayCount.getSubArrayCount(new int[]{1, 2, 3, 4, 5}, 3);
        assertEqual(subArrayCount,4+4+3+2+1);
    }

    /**
     * 倒序
     */
    @Test
    public void test1(){
        int subArrayCount = maxMinSubArrayCount.getSubArrayCount(new int[]{5, 4, 3, 2, 1}, 3);
        assertEqual(subArrayCount,4+4+3+2+1);
    }

    /**
     * 随机
     */
    @Test
    public void test2(){
        int subArrayCount = maxMinSubArrayCount.getSubArrayCount(new int[]{2, 4, 3, 1, 5}, 3);
        assertEqual(subArrayCount,4+3+2+1+1);
    }
}
