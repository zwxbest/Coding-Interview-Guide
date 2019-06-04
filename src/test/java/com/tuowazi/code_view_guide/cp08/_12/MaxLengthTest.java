package com.tuowazi.code_view_guide.cp08._12;

import com.tuowazi.test.BaseTest;
import org.junit.Test;

/**
 * @author zhangweixiao - 2019/6/3
 */
public class MaxLengthTest extends BaseTest {

    @Test
    public void test(){
        MaxLength maxLength = new MaxLength();
        int i = maxLength.maxLength(new int[]{3, -2, -4, 0, 6}, -2);
        System.out.println(i);
    }
}
