package com.tuowazi.code_view_guide.cp04._01;

import com.tuowazi.test.BaseTest;
import org.junit.Test;

/**
 * @author zhangweixiao - 2019/6/28
 */
public class FB3Test extends BaseTest {

    @Test
    public void test(){
        FB3 fb = new FB3();
        int value = fb.fb(7);
        assertEqual(value,13);
    }
}
