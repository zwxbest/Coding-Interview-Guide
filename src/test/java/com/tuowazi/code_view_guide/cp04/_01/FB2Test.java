package com.tuowazi.code_view_guide.cp04._01;

import com.tuowazi.test.BaseTest;
import org.junit.Test;

/**
 * @author zhangweixiao - 2019/6/28
 */
public class FB2Test extends BaseTest {

    @Test
    public void test(){
        FB2 fb = new FB2();
        int value = fb.fb(6);
        assertEqual(value,8);
    }
}
