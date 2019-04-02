package com.tuowazi.code_view_guide.cp01._07;

import com.tuowazi.test.BaseTest;
import org.junit.Test;

/**
 * @author zhangweixiao - 19-3-20
 */
public class MaxWindowTest extends BaseTest {

    private MaxWindow maxWindow = new MaxWindow();

    /**
     * 随机
     */
    @Test
    public void test(){
        int[] maxWindow = this.maxWindow.getMaxWindow(new int[]{4, 3, 5, 4, 3, 3, 6, 7}, 3);
        assertEqual(maxWindow,new int[]{5,5,5,4,6,7});
    }

    /**
     * 正序
     */
    @Test
    public void test1(){
        int[] maxWindow = this.maxWindow.getMaxWindow(new int[]{1,2,3,4,5}, 3);
        assertEqual(maxWindow,new int[]{3,4,5});
    }

    /**
     * 倒序
     */
    @Test
    public void test2(){
        int[] maxWindow = this.maxWindow.getMaxWindow(new int[]{5,4,3,2,1}, 3);
        assertEqual(maxWindow,new int[]{5,4,3});
    }
}
