package com.tuowazi.code_view_guide.cp01._06;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author zhangweixiao - 19-3-19
 */
public class HanoiNoRecursionTest extends HanoiTest {

    @BeforeClass
    public static void beforeClass() {
        hanoi = new HanoiNoRecursion();
    }

    @Test
    public void test() {
        int totalStepCount = hanoi.hanoi(2);
        assertEqual(totalStepCount, 8);
    }

}
