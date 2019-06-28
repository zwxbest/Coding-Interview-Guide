package com.tuowazi.code_view_guide.cp04._01;

import com.tuowazi.test.BaseTest;
import org.junit.Test;

/**
 * @author zhangweixiao - 2019/6/28
 */
public class FB1Test extends BaseTest {

    @Test
    public void test(){
        FB1 fb1 = new FB1();
        int fb = fb1.fb(6);
        assertEqual(fb,8);
    }
}
